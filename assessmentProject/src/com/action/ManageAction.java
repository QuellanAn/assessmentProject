package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;
import com.service.ManageService;

public class ManageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3638881355120182592L;

	private final int DEFAULT_PAGESIZE = 5;
	/**
	 * 链接service层
	 */
	@Resource
	private ManageService manageService;
	
/*	public ManageService getManageService() {
		return manageService;
	}

	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}*/

	public ManageAction() {
		//this.manageService = ServiceFactory.getManageService();	
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
	 * 用户姓名
	 */
	private String name;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 身份证号
	 */
	private String identificationCard;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 部门编号
	 */
	private String departmentId;
	/**
	 * 职务编号
	 */
	private String dutyId;
	/**
	 * 存放用户信息集合
	 */
	private List<ManageDto> manageDtoList;
	/**
	 * 存放部门信息集合
	 */
	private List<DepartmentDto> departmentDtoList;
	/**
	 * 存放职务信息集合
	 */
	private List<DutyDto> dutyDtoList;
	/**
	 * 
	 */
	private int type;
	/**
	 * 选中的用户参数，为用户id
	 */
	private int selectNumber;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 存放用户信息
	 */
	private ManageDto manageDto;

	
	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	public String getUserList() {
		try {
			ManageDto manageDto1 = new ManageDto();
			manageDto1.setUserName(name);
			manageDto1.setTelephone(telephone);
			manageDto1.setEmail(email);
			manageDto1.setIdentificationCard(identificationCard);
			manageDto1.setUserSex(sex);
			if (departmentId != null && !departmentId.equals("")) {
				int temp = Integer.parseInt(departmentId);
				manageDto1.setDepartmentId(temp);
			}
			if (dutyId != null && !dutyId.equals("")) {
				int temp1 = Integer.parseInt(dutyId);
				manageDto1.setDutyId(temp1);
			}
			pageBean = manageService.selectByMsg(manageDto1, page,
					DEFAULT_PAGESIZE);
			manageDtoList = pageBean.getCurPageData();
			// 实现上一页，下一页查询条件不变。
			Map<String, String> paras = new TreeMap<String, String>();
			paras.put("name", name);
			paras.put("telephone", telephone);
			paras.put("email", email);
			paras.put("sex", sex);
			paras.put("identificationCard", identificationCard);
			paras.put("departmentId", departmentId);
			paras.put("dutyId", dutyId);
			String baseUrl = "user/manager_getUserList";
			pageBean.setQueryUrl(baseUrl, paras);
		
			return "getSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取所有部门的信息
	 */
	public void getDepartmentList() {
		try {
			departmentDtoList = manageService.selectaAll();
			JSONArray jarr = JSONArray.fromObject(departmentDtoList);
			this.writeObject(jarr);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * 进入修改见面，部门列表框显示的信息
	 */
	public void getDepartmentListFirst() {
		//System.out.println(departmentId);
		try {
			int id = Integer.parseInt(departmentId);
			departmentDtoList = manageService.selectaAll();
			List<DepartmentDto> list = new ArrayList<DepartmentDto>();
			DepartmentDto dto1 = new DepartmentDto();
			for (DepartmentDto dto : departmentDtoList) {
				if (dto.getDepartmentId() == id) {
					dto1 = dto;
					list.add(dto1);
				}
			}
			for (DepartmentDto dto : departmentDtoList) {
				list.add(dto);
			}
			JSONArray jarr = JSONArray.fromObject(list);
			this.writeObject(jarr);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 获取指定部门的所有职务信息
	 */
	public void getDutyList() {
		try {
			dutyDtoList = manageService.selectByDepartment(type);
			JSONArray jarr = JSONArray.fromObject(dutyDtoList);
			this.writeObject(jarr);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 删除指定的用户信息
	 * 
	 * @return
	 */
	public String deleteUser() {
		//System.out.println(selectNumber);
		try {
			boolean b = manageService.deleteUser(selectNumber);
			if (b) {
				System.out.println("删除成功");
				ManageDto manageDto1 = new ManageDto();
				manageDto1.setUserName(name);
				manageDto1.setTelephone(telephone);
				manageDto1.setEmail(email);
				manageDto1.setIdentificationCard(identificationCard);
				manageDto1.setUserSex(sex);
				if (departmentId != null && !departmentId.equals("")) {
					int temp = Integer.parseInt(departmentId);
					manageDto1.setDepartmentId(temp);
				}
				if (dutyId != null && !dutyId.equals("")) {
					int temp1 = Integer.parseInt(dutyId);
					manageDto1.setDutyId(temp1);
				}
				pageBean = manageService.selectByMsg(manageDto1, page,
						DEFAULT_PAGESIZE);
				return "getSuccess";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过id查找对应的用户详细信息
	 * 
	 * @return
	 */
	public String getUserMsgById() {
		//System.out.println(userId);
		try {
			manageDto = manageService.getUserMsgById(userId);

			if (manageDto.getUserSex().trim().equals("1")) {
				manageDto.setUserSex("男");
			}
			if (manageDto.getUserSex().trim().equals("2")) {
				manageDto.setUserSex("女");
			}
			request.getSession().setAttribute("manageDto", manageDto);

			return "msgSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 点击每条数据后面的编辑触发的事件，将信息查找出来显示在界面上。
	 * 
	 * @return
	 */
	public String updateViewUser() {
		//System.out.println(selectNumber);
		try {
			manageDto = manageService.getUserMsgById(selectNumber);
			if (manageDto.getUserSex() != null
					&& !manageDto.getUserSex().equals("")) {
				if (manageDto.getUserSex().trim().equals("1")) {
					manageDto.setUserSex("男");
				}
				if (manageDto.getUserSex().trim().equals("2")) {
					manageDto.setUserSex("女");
				}
			}

			// session.setAttribute("manageDto", manageDto);
			return "viewSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ManageDto getManageDto() {
		return manageDto;
	}

	public void setManageDto(ManageDto manageDto) {
		this.manageDto = manageDto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSelectNumber() {
		return selectNumber;
	}

	public void setSelectNumber(int selectNumber) {
		this.selectNumber = selectNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public List<ManageDto> getManageDtoList() {
		return manageDtoList;
	}

	public void setManageDtoList(List<ManageDto> manageDtoList) {
		this.manageDtoList = manageDtoList;
	}


	
}
