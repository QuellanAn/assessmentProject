package com.dao;



import com.dto.UserDto;

public interface UserDao {

	/**
	 * 系统用户登录
	 * @param userDto 登录信息
	 * @return
	 * @throws Exception
	 */
	public UserDto loginMsg(UserDto userDto) throws Exception;
	
	/**
	 * 系统用户注册
	 * @param userDto 注册信息
	 * @return
	 * @throws Exception
	 */
	public boolean regist( UserDto userDto) throws Exception;
	
	/**
	 * 通过系统用户id获得系统用户信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public UserDto getsystemUser(int userid) throws Exception;
	
	/**
	 * 更新系统用户信息
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	public boolean systemUserUpdate( UserDto userDto)throws Exception;
}
