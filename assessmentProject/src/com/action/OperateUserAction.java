package com.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import com.dto.ManageDto;
import com.dto.Page;
import com.service.ManageService;
import com.service.ServiceFactory;
import com.util.PersonInfo;

public class OperateUserAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1086774502869206425L;

	private final int DEFAULT_PAGESIZE = 5;

	@Resource
	public ManageService manageService;


/*	public ManageService getManageService() {
		return manageService;
	}

	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
		System.out.println("注入OperateUserAction：manageService:"+manageService);
	}
*/
	public OperateUserAction() {
		this.manageService = ServiceFactory.getManageService();
	}

	/**
	 * 存放查询出的用户信息
	 */
	private Page<ManageDto> pageBean;
	/**
	 * 页数
	 */
	private int page;
	/**
	 * 用户id
	 */
	private int userid;
	/**
	 * 用户名称
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
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
	 * 身份证
	 */
	private String identificationCard;
	/**
	 * 省份
	 */
	private String address1;
	/**
	 * 市区
	 */
	private String address2;
	/**
	 * 详细地址
	 */
	private String address3;
	/**
	 * 部门id
	 */
	private int departmentId;
	/**
	 * 职务id
	 */
	private int dutyId;
	/**
	 * 存放用户的dto
	 */
	private ManageDto manageDto;

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
		/*
		 * System.out.println("*************************************");
		 * System.out.println(path); System.out.println(newFileName);
		 * System.out.println("path:" + path + "\\" + newFileName);
		 */
		path = path + "\\" + newFileName;
		return newFileName;
	}

	/**
	 * 添加新用户信息
	 * 
	 * @return
	 */
	public String addUser() {
		try {
			// System.out.println(file);
			if(file!=null){
				userImg = upload();
			}else {
				userImg="";
			}
			
			// userImg=newFileName;
			// System.out.println(userImg);
			boolean b = this.manageService.addUser(name, password, email,
					userImg, telephone, identificationCard, address1, address2,
					address3, departmentId, dutyId);
			if (b) {
				System.out.println("添加成功！");
				return "addSuccess";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 跟新用户信息
	 * 
	 * @return
	 */
	public String updateUser() {
		try {

			if (file != null) {
				userImg = upload();
				// userImg=newFileName;
			} else {
				userImg = backupImg;
			}
			// System.out.println(userImg);
			boolean b = manageService.updateUser(userid, name, password, email,
					userImg, telephone, identificationCard, address1, address2,
					address3, departmentId, dutyId);
			if (b) {
				System.out.println("修改成功！");
				ManageDto manageDto1 = new ManageDto();
				pageBean = manageService.selectByMsg(manageDto1, page,
						DEFAULT_PAGESIZE);
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 通过职务id获取对应的工资
	 */
	public void getSalary() {
		try {
			manageDto = manageService.getSalary(dutyId);
			JSONObject jarr = JSONObject.fromObject(manageDto);
			this.writeObject(jarr);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 通过身份证获取其年龄，性别，户籍所在地信息。
	 */
	public void getMsgByIdcord() {
		try {
			// System.out.println(identificationCard);
			PersonInfo personInfo = new PersonInfo();
			personInfo.setNo(identificationCard);
			ManageDto manageDto1 = new ManageDto();
			manageDto1.setUserSex(personInfo.getSex() + "");
			manageDto1.setDomicile(personInfo.getAddress());
			manageDto1.setUserAge(personInfo.getYear() + "");
			JSONObject jarr = JSONObject.fromObject(manageDto1);
			this.writeObject(jarr);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ManageDto getManageDto() {
		return manageDto;
	}

	public void setManageDto(ManageDto manageDto) {
		this.manageDto = manageDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getBackupImg() {
		return backupImg;
	}

	public void setBackupImg(String backupImg) {
		this.backupImg = backupImg;
	}

	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}

	
}
