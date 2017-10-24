package com.info;

import java.sql.Connection;

import com.dto.UserDto;

public interface UserDao {

	/**
	 * 用户登录
	 * 
	 * @param conn
	 *            连接数据库
	 * @param userDto
	 *            用户信息
	 * @return 有该用户则保存用户信息，没有该用户，返回登录失败
	 * @throws Exception
	 *             数据库异常
	 */
	public boolean login(Connection conn, UserDto userDto) throws Exception;

	public UserDto loginMsg(Connection conn, UserDto userDto) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param conn
	 *            连接数据库
	 * @return 返回注册结果，注册成功，将注册的用户信息保存，没有注册成功，则返回注册失败
	 * @throws Exception
	 *             数据库异常
	 */
	public boolean regist(Connection conn, UserDto userDto) throws Exception;

	/**
	 * 完善系统用户信息
	 * 
	 * @param conn
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public boolean systemUserUpdate(Connection conn, UserDto userDto)
			throws Exception;

	/**
	 * 通过系统用户的id查找其详细信息。
	 * 
	 * @param conn
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public UserDto getsystemUser(Connection conn, int userid) throws Exception;

}
