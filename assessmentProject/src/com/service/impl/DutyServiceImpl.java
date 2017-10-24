package com.service.impl;
import java.util.List;

import com.dao.DutyDao;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;
import com.service.DutyService;

public class DutyServiceImpl implements DutyService {

	/**
	 * 职务的dao，用于调用dao层的方法
	 */
	private DutyDao dutyDao;

	public DutyDao getDutyDao() {
		return dutyDao;
	}

	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}

	public DutyServiceImpl() {
		// TODO Auto-generated constructor stub
		// this.dutyDao = DaoFactory.getDutyDao();
	}

	@Override
	/**
	 * 选择满足条件的 职务信息
	 */
	public Page<ManageDto> selectDuty(int departmentId, int page, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub

		int totalRecord = this.dutyDao.countDuty(departmentId);
		Page<ManageDto> p = new Page<ManageDto>(totalRecord, pageSize, page);
		List<ManageDto> orig = this.dutyDao.selectDuty(departmentId,
				p.getOffset(), p.getPageSize());
		List<ManageDto> dest = ManageDto.fromList(orig);
		p.setCurPageData(dest);
		return p;

	}

	@Override
	/**
	 * 添加新的 职务信息
	 */
	public boolean addDuty(DutyDto dutyDto) throws Exception {
		// TODO Auto-generated method stub

		return this.dutyDao.addDuty(dutyDto);

	}

	@Override
	/**
	 * 删除职务信息
	 */
	public boolean delete(int dutyId) throws Exception {
		// TODO Auto-generated method stub

		return this.dutyDao.delete(dutyId);

	}

	@Override
	/**
	 * 更新职务信息
	 */
	public boolean update(DutyDto dutyDto) throws Exception {
		// TODO Auto-generated method stub
		return this.dutyDao.update(dutyDto);

	}

	@Override
	/**
	 * 通过职务id查询对应的职务信息
	 */
	public ManageDto selectDutyById(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		return this.dutyDao.selectDutyById(dutyId);

	}

}
