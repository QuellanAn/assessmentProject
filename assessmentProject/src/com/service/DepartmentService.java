package com.service;

import com.dto.DepartmentDto;
import com.dto.Page;

public interface DepartmentService {

	/**
	 * 查找出所有的部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public Page<DepartmentDto> selectAllDepartment(String msg,int page, int pageSize)
			throws Exception;

	/**
	 * 通过id查找出相应的部门信息
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	public DepartmentDto selectDepartmentById(int department) throws Exception;

	/**
	 * 添加新的部门信息
	 * 
	 * @param departmentDto
	 * @return
	 * @throws Exception
	 */
	public boolean addDepartment(DepartmentDto departmentDto) throws Exception;

	/**
	 * 删除指定的部门信息
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDepartment(int departmentId) throws Exception;

	/**
	 * 修改指定的部门信息
	 * 
	 * @param departmentDto
	 * @return
	 * @throws Exception
	 */
	public boolean updateDepartment(DepartmentDto departmentDto)
			throws Exception;

}
