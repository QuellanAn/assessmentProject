package com.dao;

import java.util.List;

import com.dto.DepartmentDto;

public interface DepartmentDao {

	/**
	 * 查找出所有的部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentDto> selectAllDepartment(String msg, int offset,
			int length) throws Exception;

	/**
	 * 总的数据有多少条
	 * @return
	 * @throws Exception
	 */
	public int countDepartment(String msg) throws Exception;

	/**
	 * 通过id查找出对应的部门信息。
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public DepartmentDto selectDepartmentById(int departmentId)
			throws Exception;

	/**
	 * 添加新的部门信息
	 * 
	 * @param departmentDto
	 * @return
	 * @throws Exception
	 */
	public boolean addDepartment(DepartmentDto departmentDto)
			throws Exception;

	/**
	 * 删除指定的部门信息
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDepartment(int departmentId)
			throws Exception;

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
