package com.service;

import com.service.impl.DepartmentServiceImpl;
import com.service.impl.DutyServiceImpl;
import com.service.impl.ManageServiceImpl;
import com.service.impl.UserServiceImpl;

public class ServiceFactory {

	public static UserService getUserService() {
		return new UserServiceImpl();
	}

	public static ManageService getManageService() {
		return new ManageServiceImpl();
	}

	public static DepartmentService getDepartmentService() {
		return new DepartmentServiceImpl();
	}

	public static DutyService getDutyService() {
		return new DutyServiceImpl();
	}

}
