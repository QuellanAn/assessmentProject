package com.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;
import com.dto.UserDto;
import com.service.UserService;
public class UserAction extends BaseAction {

	private static final long serialVersionUID = -6365669988929582792L;
	@Resource
	private UserService userService;
	//public ManageService manageService;
	/*public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		//System.out.println("注入：");
		this.userService = userService;
		//System.out.println("userService:"+userService);
	}*/
	public UserAction() {
		//this.userService = ServiceFactory.getUserService();
		//this.manageService = ServiceFactory.getManageService();
		//System.out.println("UserAction实例化。。。");
	}

	/**
	 * 登录信息
	 */
	private String msg;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 注册信息
	 */
	private String emailMsg;
	/**
	 * 注册密码
	 */
	private String password1;
	/**
	 * 注册密码的确认密码
	 */
	private String password2;
	/**
	 * 存放用户信息
	 */
	private Page<ManageDto> pageBean;
	/**
	 * 页数
	 */
	private int page;
	/**
	 * 部门信息集合
	 */
	private List<DepartmentDto> departmentDtoList;
	/**
	 * 职务信息集合
	 */
	private List<DutyDto> dutyDtoList;
	/**
	 * 用户dto
	 */
	private UserDto userDto;
	/**
	 * 用户dto
	 */
	private ManageDto manageDto;
	/**
	 * 系统用户id
	 */
	private int systemuserid;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 图片
	 */
	private String userImg;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 原始图片
	 */
	private String backupImg;
	/**
	 * 文件
	 */
	private File file;
	/**
	 * 上传文件名
	 */
	private String fileFileName;
	/**
	 * 保存上传文件的目录
	 */
	private String uploadDir = "userImages";
	/**
	 * 新文件名称
	 */
	private String newFileName = null;

	/**
	 * 上传图片
	 * 
	 * @throws Exception
	 */
	public String upload() throws Exception {
		long now = new Date().getTime();
		String path = ServletActionContext.getServletContext().getRealPath(
				uploadDir);
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();
		int index = fileFileName.lastIndexOf('.');
		if (index != -1)
			newFileName = now + fileFileName.substring(index);
		else
			newFileName = Long.toString(now);
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(new File(dir, newFileName));
			bos = new BufferedOutputStream(fos);
			byte[] buf = new byte[4096];
			int len = -1;
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bis)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (null != bos)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("*************************************");
		// System.out.println(path);
		// System.out.println(newFileName);
		// System.out.println("path:"+path+"\\"+newFileName);
		// path=path+"\\"+newFileName;
		return newFileName;
	}

	/**
	 * 系统用户登录
	 * 
	 * @return
	 */
	public String login() {
		try {
			// System.out.println(msg);
			// System.out.println(password);
			/*
			 * boolean b=userService.login(msg, password); if(b){
			 * System.out.println("登录成功"); return "loginSuccess"; }
			 */
			userDto = userService.loginMsg(msg, password);
			if (userDto != null) {
				System.out.println("登录成功");
				request.getSession().setAttribute("userDto", userDto);
				//departmentDtoList = manageService.selectaAll();
				//request.getSession().setAttribute("departmentDtoList", departmentDtoList);
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("登录失败");
		request.getSession().setAttribute("loginResult", "error");
		return ERROR;
	}

	/**
	 * 随机验证码检验
	 */
	public void checkVerificationCode() {
		// 获得输入的验证码和session中的验证码进行比较。
		String codeString = request.getParameter("verificationCode")
				.toLowerCase();
		String checkString = (String) request.getSession().getAttribute("validateCode");
		String check = checkString.toLowerCase();
		if (codeString.equals(check)) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "0");
			writeJSON(jsonObject);
		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "1");
			writeToJSON(jsonObject);
		}
	}

	/**
	 * 注册新的系统用户
	 * 
	 * @return
	 */
	public String regist() {
		try {

			if (password1.equals(password2)) {
				boolean b = userService.regist(emailMsg, password1);
				if (b) {
					System.out.println("注册成功");
					UserDto userDto = userService.loginMsg(emailMsg, password1);
					request.getSession().setAttribute("userDto", userDto);
					password2 = "";
					return SUCCESS;
				}
			} else {
				System.out.println("两次密码不一致");
				return ERROR;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ERROR;

	}

	/**
	 * 完善系统用户信息。
	 * 
	 * @return
	 */
	public String systemUserUpdate() {
		try {

			// System.out.println(systemuserid);
			// System.out.println(file);
			if (file != null) {
				userImg = upload();
				// userImg=newFileName;
			} else {
				userImg = backupImg;
			}
			// System.out.println(userImg);
			boolean b = userService.systemUserUpdate(systemuserid, name,
					password,userImg, telephone, email);
			if (b) {
				System.out.println("系统用户信息更新成功！");
				userDto = userService.getsystemUser(systemuserid);
				request.getSession().setAttribute("userDto", userDto);
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exceptio
		}
		return null;
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public String logout() {
		request.getSession().setAttribute("userDto", null);
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}

	/**
	 * 私有变量的get和set方法
	 * 
	 * @return
	 */

	public String getName() {
		return name;
	}

	public int getSystemuserid() {
		return systemuserid;
	}

	public void setSystemuserid(int systemuserid) {
		this.systemuserid = systemuserid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBackupImg() {
		return backupImg;
	}

	public void setBackupImg(String backupImg) {
		this.backupImg = backupImg;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public ManageDto getManageDto() {
		return manageDto;
	}

	public void setManageDto(ManageDto manageDto) {
		this.manageDto = manageDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<DepartmentDto> getDepartmentDtoList() {
		return departmentDtoList;
	}

	public void setDepartmentDtoList(List<DepartmentDto> departmentDtoList) {
		this.departmentDtoList = departmentDtoList;
	}

	public List<DutyDto> getDutyDtoList() {
		return dutyDtoList;
	}

	public void setDutyDtoList(List<DutyDto> dutyDtoList) {
		this.dutyDtoList = dutyDtoList;
	}

	public Page<ManageDto> getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page<ManageDto> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailMsg() {
		return emailMsg;
	}

	public void setEmailMsg(String emailMsg) {
		this.emailMsg = emailMsg;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}





}
