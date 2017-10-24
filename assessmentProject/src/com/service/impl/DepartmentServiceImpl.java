package com.service.impl;

import java.util.List;

import com.dao.DepartmentDao;
import com.dto.DepartmentDto;
import com.dto.Page;
import com.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	/**
	 * 部门的dao,调用dao层的方法
	 */
	private DepartmentDao departmentDao;

	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public DepartmentServiceImpl() {
		// TODO Auto-generated constructor stub
		//this.departmentDao = DaoFactory.getDepartmentDao();
	}

	@Override
	/**
	 * 查找指定页面的部门信息
	 */
	public Page<DepartmentDto> selectAllDepartment(String msg,int page, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub

			int totalRecord = this.departmentDao.countDepartment(msg);
			Page<DepartmentDto> p = new Page<DepartmentDto>(totalRecord,
					pageSize, page);
			List<DepartmentDto> orig = this.departmentDao.selectAllDepartment(msg, p.getOffset(), p.getPageSize());
			List<DepartmentDto> dest = DepartmentDto.fromList(orig);
			p.setCurPageData(dest);
			return p;

	}

	@Override
	/**
	 * 添加新的部门信息
	 */
	public boolean addDepartment(DepartmentDto departmentDto) throws Exception {
		// TODO Auto-generated method stub
			return this.departmentDao.addDepartment( departmentDto);

	}

	@Override
	/**
	 * 删除部门信息
	 */
	public boolean deleteDepartment(int departmentId) throws Exception {
		// TODO Auto-generated method stub
			return this.departmentDao.deleteDepartment(departmentId);

	}

	@Override
	/**
	 * 跟新部门信息
	 */
	public boolean updateDepartment(DepartmentDto departmentDto)
			throws Exception {
		// TODO Auto-generated method stub
			return this.departmentDao.updateDepartment( departmentDto);

	}

	@Override
	/**
	 * 通过部门id查找对应的部门信息
	 */
	public DepartmentDto selectDepartmentById(int department) throws Exception {
		// TODO Auto-generated method stub
			return this.departmentDao.selectDepartmentById(department);

	}

}
