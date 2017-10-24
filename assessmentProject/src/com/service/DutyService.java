package com.service;

import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;

public interface DutyService {

	/**
	 * 查询职务信息，查询条件可以为部门
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public Page<ManageDto> selectDuty(int departmentId, int page, int pageSize)
			throws Exception;

	/**
	 * 通过职务id查找出相应的职务信息
	 * 
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public ManageDto selectDutyById(int dutyId) throws Exception;

	/**
	 * 添加职务信息
	 * 
	 * @param dutyDto
	 * @return
	 * @throws Exception
	 */
	public boolean addDuty(DutyDto dutyDto) throws Exception;

	/**
	 * 删除职务信息
	 * 
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int dutyId) throws Exception;

	/**
	 * 修改职务信息
	 * 
	 * @param dutyDto
	 * @return
	 * @throws Exception
	 */
	public boolean update(DutyDto dutyDto) throws Exception;

}
