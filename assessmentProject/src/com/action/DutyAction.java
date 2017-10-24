package com.action;


import javax.annotation.Resource;

import net.sf.json.JSONObject;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;
import com.service.DutyService;


public class DutyAction extends BaseAction {

	/** 序列号 */
	private static final long serialVersionUID = -3333355353954749722L;

	private final int DEFAULT_PAGESIZE = 5;
	
	@Resource
	private DutyService dutyService;

	public DutyAction() {
		//this.dutyService = ServiceFactory.getDutyService();
	}

	/**
	 * 存放职务信息
	 */
	private Page<ManageDto> pageBean;
	/**
	 * 页数
	 */
	private int page;
/*	
	private int dutyId;
	private int departmentId;
	private String dutyName;
	private String  dutySalary;*/
	/**
	 * 从前台页面选中的数据传递的参数，为对应的部门id.
	 */
	private int selectNumber;
	/**
	 * 存放通过id找到对于那个的职务信息
	 */
	private ManageDto manageDto;

	/**
	 * 
	 */
	private DutyDto dutyDto;
	
	/**
	 * 查询满足条件的职务信息
	 */
	public String getDuty() {
		try {
			if(dutyDto==null){
				pageBean = dutyService.selectDuty(0, page,
						DEFAULT_PAGESIZE);
			}else{
			pageBean = dutyService.selectDuty(dutyDto.getDepartmentId(), page,
					DEFAULT_PAGESIZE);
			}
			String baseUrl = "duty/duty_getDuty";
			pageBean.setQueryUrl(baseUrl);
			return "getSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加新的职务
	 * @return
	 */
	public String addDuty() {
		try {			
			boolean b = dutyService.addDuty(dutyDto);
			if (b) {
				System.out.println("添加成功！");
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("薪资输入不正确，请从新输入：");
			return SUCCESS;
		}
		return null;
	}

	/**
	 * 删除职务
	 */
	public void deleteDuty() {
		try {
			boolean b = dutyService.delete(selectNumber);
			if (b) {
				System.out.println("删除成功");
				if(dutyDto==null){
					pageBean = dutyService.selectDuty(0, page,
							DEFAULT_PAGESIZE);
				}else{
					pageBean = dutyService.selectDuty(dutyDto.getDepartmentId(), page,
							DEFAULT_PAGESIZE);
				}
				
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
	 * 通过职务id，查找对应的职务信息
	 * @return
	 */
	public String updateViewDuty() {
		try {
			//System.out.println(selectNumber);
			manageDto = dutyService.selectDutyById(selectNumber);
			return "viewUpdateSuccess";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 更新职务信息
	 * @return
	 */
	public String dutyUpdate() {
		try {
			boolean b = dutyService.update(dutyDto);
			if (b) {
				System.out.println("修改成功");
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return null;
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

	

	public DutyDto getDutyDto() {
		return dutyDto;
	}

	public void setDutyDto(DutyDto dutyDto) {
		this.dutyDto = dutyDto;
	}

	public ManageDto getManageDto() {
		return manageDto;
	}

	public void setManageDto(ManageDto manageDto) {
		this.manageDto = manageDto;
	}

	public int getSelectNumber() {
		return selectNumber;
	}

	public void setSelectNumber(int selectNumber) {
		this.selectNumber = selectNumber;
	}
	
}
