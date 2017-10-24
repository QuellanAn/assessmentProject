package com.service.impl;

import java.util.List;

import com.dao.ManageDao;
import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.Page;
import com.service.ManageService;
import com.util.PersonInfo;

public class ManageServiceImpl implements ManageService {

	/**
	 * 用户信息的dao,用户调用dao层的方法
	 */
	private ManageDao manageDao;

	public ManageServiceImpl() {
		// this.manageDao = DaoFactory.getManageDao();
	}

	public ManageDao getManageDao() {
		return manageDao;
	}

	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}

	@Override
	/**
	 * 查询所有的部门信息
	 */
	public List<DepartmentDto> selectaAll() throws Exception {
		// TODO Auto-generated method stub

		return manageDao.selectAll();

	}

	@Override
	/**
	 * 查询指定部门的所有职务信息
	 */
	public List<DutyDto> selectByDepartment(int departmentId) throws Exception {
		// TODO Auto-generated method stub

		return manageDao.selectByDepartment(departmentId);

	}

	@Override
	/**
	 * 查询满足条件的用户信息条数
	 */
	public int countSelectByMsg(ManageDto manageDto) throws Exception {
		// TODO Auto-generated method stub

		return manageDao.countSelectByMsg(manageDto);

	}

	@Override
	/**
	 * 查询满足条件的 用户信息
	 */
	public Page<ManageDto> selectByMsg(ManageDto manageDto, int page,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub

		int totalRecord = this.manageDao.countSelectByMsg(manageDto);
		Page<ManageDto> p = new Page<ManageDto>(totalRecord, pageSize, page);
		List<ManageDto> orig = this.manageDao.selectByMsg(manageDto,
				p.getOffset(), p.getPageSize());
		List<ManageDto> dest = ManageDto.fromList(orig);
		p.setCurPageData(dest);
		return p;

	}

	@Override
	/**
	 * 删除用户信息
	 */
	public boolean deleteUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		ManageDto manageDto = this.manageDao.getUserMsgById(userId);
		int departmentId = manageDto.getDepartmentId();
		boolean b = this.manageDao.deleteUser(userId);
		if (b) {
			// int count = this.manageDao.selectDepartmentCount(departmentId);
			int count = 0;
			List<DutyDto> list = this.manageDao
					.selectByDepartment(departmentId);
			for (DutyDto dutyDto : list) {
				int temp = this.manageDao.departmentCountByDutyId(dutyDto
						.getDutyId());
				count += temp;
			}
			//count = count - 1;
			boolean c = this.manageDao.updateDepartmentCount(departmentId,
					count);
			if (c) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 通过用户id查询对应的用户信息
	 */
	public ManageDto getUserMsgById(int userId) throws Exception {
		// TODO Auto-generated method stub

		return this.manageDao.getUserMsgById(userId);

	}

	@Override
	/**
	 * 添加新的用户信息
	 */
	public boolean addUser(String name, String password, String email,
			String userImg, String telephone, String identificationCard,
			String address1, String address2, String address3,
			int departmentId, int dutyId) throws Exception {
		// TODO Auto-generated method stub

		switch (address1) {
		case "0":
			address1 = "北京";
			break;
		case "1":
			address1 = "上海";
			break;
		case "2":
			address1 = "天津";
			break;
		case "3":
			address1 = "重庆";
			break;
		case "4":
			address1 = "河北";
			break;
		case "5":
			address1 = "山西";
			break;
		case "6":
			address1 = "内蒙古";
			break;
		case "7":
			address1 = "辽宁";
			break;
		case "8":
			address1 = "吉林";
			break;
		case "9":
			address1 = "黑龙江";
			break;
		case "10":
			address1 = "江苏";
			break;
		case "11":
			address1 = "浙江";
			break;
		case "12":
			address1 = "安徽";
			break;
		case "13":
			address1 = "福建";
			break;
		case "14":
			address1 = "江西";
			break;
		case "15":
			address1 = "山东";
			break;
		case "16":
			address1 = "河南";
			break;
		case "17":
			address1 = "湖北";
			break;
		case "18":
			address1 = "湖南";
			break;
		case "19":
			address1 = "广东";
			break;
		case "20":
			address1 = "广西";
			break;
		case "21":
			address1 = "海南";
			break;
		case "22":
			address1 = "四川";
			break;
		case "23":
			address1 = "贵州";
			break;
		case "24":
			address1 = "云南";
			break;
		case "25":
			address1 = "西藏";
			break;
		case "26":
			address1 = "陕西";
			break;
		case "27":
			address1 = "甘肃";
			break;
		case "28":
			address1 = "宁夏";
			break;
		case "29":
			address1 = "青海";
			break;
		case "30":
			address1 = "新疆";
			break;
		case "31":
			address1 = "香港";
			break;
		case "32":
			address1 = "澳门";
			break;
		case "33":
			address1 = "台湾";
			break;
		default:
			break;
		}

		ManageDto manageDto = new ManageDto();
		manageDto.setUserName(name);
		manageDto.setPassword(password);
		manageDto.setEmail(email);
		manageDto.setTelephone(telephone);
		manageDto.setIdentificationCard(identificationCard);
		PersonInfo personInfo = new PersonInfo();
		personInfo.setNo(identificationCard);
		manageDto.setUserSex(personInfo.getSex() + "");
		manageDto.setUserAge("" + personInfo.getYear());
		manageDto.setUserImg(userImg);
		// System.out.println(personInfo.getAddress());
		manageDto.setDomicile(personInfo.getAddress());
		manageDto.setAddress(address1 + address2 + address3);
		if (departmentId == 0) {
			departmentId = 1;
		}
		manageDto.setDepartmentId(departmentId);
		if (dutyId == 0) {
			dutyId = 1;
		}
		manageDto.setDutyId(dutyId);
		boolean b = manageDao.addUser(manageDto);
		if (b) {

			// int count = this.manageDao.selectDepartmentCount(departmentId);
			int count = 0;
			List<DutyDto> list = this.manageDao
					.selectByDepartment(departmentId);
			for (DutyDto dutyDto : list) {
				int temp = this.manageDao.departmentCountByDutyId(dutyDto
						.getDutyId());
				count += temp;
			}
			//count = count + 1;
			boolean c = this.manageDao.updateDepartmentCount(departmentId,
					count);
			if (c) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	/**
	 * 通过用户id查找对应的薪资
	 */
	public ManageDto getSalary(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		return this.manageDao.getSalary(dutyId);

	}

	@Override
	/**
	 * 更新用户信息
	 */
	public boolean updateUser(int userId, String name, String password,
			String email, String userImg, String telephone,
			String identificationCard, String address1, String address2,
			String address3, int departmentId, int dutyId) throws Exception {
		// TODO Auto-generated method stub
		switch (address1) {
		case "0":
			address1 = "北京";
			break;
		case "1":
			address1 = "上海";
			break;
		case "2":
			address1 = "天津";
			break;
		case "3":
			address1 = "重庆";
			break;
		case "4":
			address1 = "河北";
			break;
		case "5":
			address1 = "山西";
			break;
		case "6":
			address1 = "内蒙古";
			break;
		case "7":
			address1 = "辽宁";
			break;
		case "8":
			address1 = "吉林";
			break;
		case "9":
			address1 = "黑龙江";
			break;
		case "10":
			address1 = "江苏";
			break;
		case "11":
			address1 = "浙江";
			break;
		case "12":
			address1 = "安徽";
			break;
		case "13":
			address1 = "福建";
			break;
		case "14":
			address1 = "江西";
			break;
		case "15":
			address1 = "山东";
			break;
		case "16":
			address1 = "河南";
			break;
		case "17":
			address1 = "湖北";
			break;
		case "18":
			address1 = "湖南";
			break;
		case "19":
			address1 = "广东";
			break;
		case "20":
			address1 = "广西";
			break;
		case "21":
			address1 = "海南";
			break;
		case "22":
			address1 = "四川";
			break;
		case "23":
			address1 = "贵州";
			break;
		case "24":
			address1 = "云南";
			break;
		case "25":
			address1 = "西藏";
			break;
		case "26":
			address1 = "陕西";
			break;
		case "27":
			address1 = "甘肃";
			break;
		case "28":
			address1 = "宁夏";
			break;
		case "29":
			address1 = "青海";
			break;
		case "30":
			address1 = "新疆";
			break;
		case "31":
			address1 = "香港";
			break;
		case "32":
			address1 = "澳门";
			break;
		case "33":
			address1 = "台湾";
			break;
		default:
			break;
		}
		ManageDto manageDto = new ManageDto();
		manageDto.setUserId(userId);
		manageDto.setUserName(name);
		manageDto.setPassword(password);
		manageDto.setEmail(email);
		manageDto.setTelephone(telephone);
		manageDto.setIdentificationCard(identificationCard);
		PersonInfo personInfo = new PersonInfo();
		personInfo.setNo(identificationCard);
		manageDto.setUserSex(personInfo.getSex() + "");
		manageDto.setUserAge("" + personInfo.getYear());
		manageDto.setUserImg(userImg);
		// System.out.println(personInfo.getAddress());
		manageDto.setDomicile(personInfo.getAddress());
		if (address1 != null && !address1.equals("") && address2 != null
				&& !address2.equals("")) {
			manageDto.setAddress(address1 + address2 + address3);
		} else {
			manageDto.setAddress(address3);
		}

		manageDto.setDepartmentId(departmentId);
		manageDto.setDutyId(dutyId);
		boolean b = this.manageDao.updateUser(manageDto);
		if (b) {

			// int count = this.manageDao.selectDepartmentCount(departmentId);
			int count = 0;
			List<DutyDto> list = this.manageDao
					.selectByDepartment(departmentId);
			for (DutyDto dutyDto : list) {
				int temp = this.manageDao.departmentCountByDutyId(dutyDto
						.getDutyId());
				count += temp;
			}
			boolean c = this.manageDao.updateDepartmentCount(departmentId,
					count);
			if (c) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
