package com.service;

import com.dto.UserDto;

public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @param msg
	 *            登录信息，可能为用户昵称，或是电话，或是邮箱
	 * @param password
	 *            密码
	 * @return 返回登陆结果，登录成功，返回用户信息，登录失败，返回登录失败。
	 * @throws Exception
	 *             抛出异常
	 */

	public UserDto loginMsg(String msg, String password) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param emailMsg
	 *            注册信息，可能为电话或这邮箱
	 * @param password
	 *            密码
	 * @return 返回注册结果。
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean regist(String emailMsg, String password) throws Exception;

	/**
	 * 完善系统用户的信息
	 * 
	 * @param userid
	 * @param userName
	 * @param password
	 * @param telephone
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean systemUserUpdate(int userid, String userName,
			String password, String userImg, String telephone, String email)
			throws Exception;

	/**
	 * 通过id查找对应的系统用户详细信息
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public UserDto getsystemUser(int userid) throws Exception;

}
