package com.dao;

import java.util.List;

import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;

public interface ManageDao {
	/**
	 * 查找出数据部所有的部门信息。
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentDto> selectAll() throws Exception;

	/**
	 * 根据选择的部门信息，来查找出相应的职务信息。
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public List<DutyDto> selectByDepartment( int departmentId)
			throws Exception;

	/**
	 * 根据查询添加查询出满足条件的数据有多少条。
	 * @param manageDto
	 * @return
	 * @throws Exception
	 */
	public int countSelectByMsg(ManageDto manageDto)
			throws Exception;

	/**
	 * 根据选择的条件进行查询出满足条件的数据。
	 * @param manageDto
	 *            查询信息
	 * @param offset
	 *            起始行 用于分页查询
	 * @param length
	 *            长度
	 * @return 返回结果
	 * @throws Exception
	 *             抛出异常
	 */
	public List<ManageDto> selectByMsg( ManageDto manageDto,
			int offset, int length) throws Exception;

	/**
	 * 删除选定的用户信息
	 * @param userId
	 *            需要删除的用户id
	 * @return 返回删除成功 或失败
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean deleteUser( int userId) throws Exception;

	/**
	 * 修改指定的用户信息
	 * @param manageDto
	 *            需要修改的用户信息
	 * @return 返回修改成功或失败
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean updateUser( ManageDto manageDto)
			throws Exception;

	/**
	 * 通过用户id 查找该用户的详细信息。
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ManageDto getUserMsgById( int userId)
			throws Exception;

	/**
	 * 添加用户信息。
	 * @param manageDto
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(ManageDto manageDto)
			throws Exception;

	/**
	 * 通过职务编号查找对应的工资信息。
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public ManageDto getSalary( int dutyId) throws Exception;
	
	/**
	 * 通过部门id修改其对应的部门人数
	 * @param departmentId
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public boolean updateDepartmentCount(int departmentId,int count)throws Exception;
	
	/**
	 * 通过部门id查找对应的部门人数
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public int selectDepartmentCount(int departmentId)throws Exception;
	
	/**
	 * 通过职务id获得该职务的人数。
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public int departmentCountByDutyId(int dutyId)throws Exception;
}
