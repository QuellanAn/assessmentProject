package com.dao;

import java.util.List;

import com.dto.DutyDto;
import com.dto.ManageDto;

public interface DutyDao {

	/**
	 * 查询职务信息，查询条件可以为部门
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public List<ManageDto> selectDuty(int departmentId,
			int offset, int length) throws Exception;

	/**
	 * 查询满足条件的数据
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public int countDuty(int departmentId) throws Exception;

	/**
	 * 通过id查找出对应的职位信息。
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public ManageDto selectDutyById( int dutyId)
			throws Exception;

	/**
	 * 添加职务信息
	 * @param dutyDto
	 * @return
	 * @throws Exception
	 */
	public boolean addDuty(DutyDto dutyDto) throws Exception;

	/**
	 * 删除职务信息
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public boolean delete(int dutyId) throws Exception;

	/**
	 * 修改职务信息
	 * @param dutyDto
	 * @return
	 * @throws Exception
	 */
	public boolean update(DutyDto dutyDto) throws Exception;
}
