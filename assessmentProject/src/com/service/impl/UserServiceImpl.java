package com.service.impl;

import com.dao.UserDao;
import com.dto.UserDto;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	/**
	 * 系统用户的dao,用户登录和注册
	 */
	private UserDao userDao;

/*	public UserServiceImpl() {
		this.userDao = DaoFactory.getUserDao();
	}*/
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	/**
	 * 登录，返回登陆用户的信息
	 */
	public UserDto loginMsg(String msg, String password) throws Exception {
		// TODO Auto-generated method stub
		UserDto dto = new UserDto();
		try {
			UserDto userDto = new UserDto();
			userDto.setUserName(msg);
			userDto.setPassword(password);
			dto = userDao.loginMsg(userDto);

			if (dto == null || dto.equals("")) {
				userDto.setUserName("");
				userDto.setTelephone(msg);
				dto = userDao.loginMsg(userDto);
				if (dto == null || dto.equals("")) {
					userDto.setUserName("");
					userDto.setTelephone("");
					userDto.setEmail(msg);
					dto = userDao.loginMsg(userDto);
				}
			}
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	/**
	 * 注册
	 */
	public boolean regist(String emailMsg, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			UserDto userDto = new UserDto();
			// 判断emailMsg是手机号还是邮箱。
			int b = emailMsg.indexOf("@");
			if (b < 0) {
				userDto.setTelephone(emailMsg);
				userDto.setPassword(password);
				return userDao.regist(userDto);
			} else {
				userDto.setEmail(emailMsg);
				userDto.setPassword(password);
				return userDao.regist(userDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	/**
	 * 完善用户信息
	 */
	public boolean systemUserUpdate(int userid, String userName,
			String password, String userImg, String telephone, String email)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			UserDto userDto = new UserDto();
			userDto.setUserId(userid);
			userDto.setUserName(userName);
			userDto.setPassword(password);
			userDto.setUserImg(userImg);
			userDto.setTelephone(telephone);
			userDto.setEmail(email);
			return this.userDao.systemUserUpdate(userDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	/**
	 * 通过系统用户id获得其详细信息。
	 */
	public UserDto getsystemUser(int userid) throws Exception {
		// TODO Auto-generated method stub
		return this.userDao.getsystemUser(userid);
	}

}
