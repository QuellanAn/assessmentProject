package com.service;

import java.util.List;

import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;

public interface ManageService {

	/**
	 * 查找所有部门信息
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentDto> selectaAll() throws Exception;

	/**
	 * 根据部门信息查找到所在部门所有的职务信息
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public List<DutyDto> selectByDepartment(int departmentId) throws Exception;

	/**
	 * 根据查询条件查询出满足添加的数据有多少条
	 * 
	 * @param manageDto
	 * @return
	 * @throws Exception
	 */
	public int countSelectByMsg(ManageDto manageDto) throws Exception;

	/**
	 * 根据查询条件查询出满足条件的数据。
	 * 
	 * @param manageDto
	 * @param offset
	 * @param length
	 * @return
	 * @throws Exception
	 */
	public Page<ManageDto> selectByMsg(ManageDto manageDto, int page,
			int pageSize) throws Exception;

	/**
	 * 删除选定的用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUser(int userId) throws Exception;

	/**
	 * 修改指定的用户信息
	 * 
	 * @param manageDto
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(int userId, String name, String password,
			String email, String userImg, String telephone,
			String identificationCard, String address1, String address2,
			String address3, int departmentId, int dutyId) throws Exception;

	/**
	 * 通过用户id 查找该用户的详细信息。
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ManageDto getUserMsgById(int userId) throws Exception;

	/**
	 * 添加用户信息
	 * 
	 * @param name
	 * @param password
	 * @param email
	 * @param telephone
	 * @param identificationCard
	 * @param address1
	 * @param address2
	 * @param address3
	 * @param departmentId
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(String name, String password, String email,
			String userImg, String telephone, String identificationCard,
			String address1, String address2, String address3,
			int departmentId, int dutyId) throws Exception;

	/**
	 * 通过职务编号查找对应的工资信息。
	 * 
	 * @param dutyId
	 * @return
	 * @throws Exception
	 */
	public ManageDto getSalary(int dutyId) throws Exception;

}
