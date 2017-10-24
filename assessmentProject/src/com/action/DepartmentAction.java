package com.action;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import com.dto.DepartmentDto;
import com.dto.Page;
import com.service.DepartmentService;

public class DepartmentAction extends BaseAction {

	private static final long serialVersionUID = -7851548120268355564L;
	private final int DEFAULT_PAGESIZE = 5;

	@Resource
	private DepartmentService departmentService;

	public DepartmentAction() {
		//this.departmentService = ServiceFactory.getDepartmentService();
	}

	/**
	 * 保存查询部门的数据
	 */
	private Page<DepartmentDto> pageBean;
	/**
	 * 页数
	 */
	private int page;
	/**
	 * 部门id
	 */
	private int departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部门人数
	 */
	private int departmentCount;
	/**
	 * 从前台页面选中的数据传递的参数，为对应的部门id.
	 */
	private int selectNumber;
	/**
	 * 部门对象，存到一个部门的信息 
	 */
	private DepartmentDto departmentDto;

	/**
	 * 查询条件，部门信息
	 */
	private String msg;
	
	/**
	 * 查询部门信息
	 * @return
	 */
	public String getDepartment() {
		try {
			pageBean = departmentService.selectAllDepartment(msg,page,
					DEFAULT_PAGESIZE);
			String baseUrl = "department/department_getDepartment";
			pageBean.setQueryUrl(baseUrl);
			return "getSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加部门信息
	 * @return
	 */
	public String addDepartment() {
		try {
			DepartmentDto departmentDto = new DepartmentDto();
			departmentDto.setDepartmentName(departmentName);
			departmentDto.setDepartmentCount(departmentCount);
			boolean b = departmentService.addDepartment(departmentDto);
			if (b) {
				System.out.println("添加成功！");
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 删除部门信息
	 */
	public void deleteDepartment() {
		try {
			boolean b = departmentService.deleteDepartment(selectNumber);
			if (b) {
				System.out.println("删除成功");
				pageBean = departmentService.selectAllDepartment(msg,page,
						DEFAULT_PAGESIZE);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", "0");
				writeJSON(jsonObject);
			} else {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("result", "1");
				writeJSON(jsonObject);
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "1");
			writeJSON(jsonObject);
		}
	}

	/**
	 * 点击编辑按钮，触发的事件，通过部门id 获得对应的部门信息
	 * @return
	 */
	public String updateViewDepartment() {
		try {
			//System.out.println(selectNumber);
			departmentDto = departmentService
					.selectDepartmentById(selectNumber);
			return "updateSuccess";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 更新部门信息
	 * @return
	 */
	public String departmentUpdate() {
		try {
			DepartmentDto departmentDto = new DepartmentDto();
			departmentDto.setDepartmentId(departmentId);
			departmentDto.setDepartmentName(departmentName);
			departmentDto.setDepartmentCount(departmentCount);
			boolean b = departmentService.updateDepartment(departmentDto);
			if (b) {
				System.out.println("修改成功");
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return null;
	}

	public Page<DepartmentDto> getPageBean() {
		return pageBean;
	}

	public void setPageBean(Page<DepartmentDto> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentCount() {
		return departmentCount;
	}

	public void setDepartmentCount(int departmentCount) {
		this.departmentCount = departmentCount;
	}

	public int getSelectNumber() {
		return selectNumber;
	}

	public void setSelectNumber(int selectNumber) {
		this.selectNumber = selectNumber;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
		//System.out.println("注入：departmentService:"+departmentService);
	}
	

}
