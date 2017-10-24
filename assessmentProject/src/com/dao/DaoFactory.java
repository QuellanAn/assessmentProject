package com.dao;

import com.dao.jdbc.DepartmentDaoImpl;
import com.dao.jdbc.DutyDaoImpl;
import com.dao.jdbc.ManageDaoImpl;
import com.dao.jdbc.UserDaoImpl;

public class DaoFactory {

	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}

	public static ManageDao getManageDao() {
		return new ManageDaoImpl();
	}

	public static DepartmentDao getDepartmentDao() {
		return new DepartmentDaoImpl();
	}

	public static DutyDao getDutyDao() {
		return new DutyDaoImpl();
	}
}
