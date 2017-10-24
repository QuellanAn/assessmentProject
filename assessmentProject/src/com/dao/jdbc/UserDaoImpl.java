package com.dao.jdbc;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dao.UserDao;
import com.dto.UserDto;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Override
	/**
	 * 系统用户登录
	 */
	public UserDto loginMsg(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub		
		try {
			JdbcTemplate jt=this.getJdbcTemplate();
			String sql = "select * from system_user where 1=1 ";
			// 拼接条件
			if (userDto.getUserName() != null && !userDto.getUserName().equals("")) {
				sql += " AND user_name= '" + userDto.getUserName()
						+ "' and user_password=?";
			}
			if (userDto.getTelephone() != null
					&& !userDto.getTelephone().equals("")) {
				sql += " AND telephone= '" + userDto.getTelephone()
						+ "' and user_password=?";
			}
			if (userDto.getEmail() != null && !userDto.getEmail().equals("")) {
				sql += " AND email= '" + userDto.getEmail()
						+ "' and user_password=?";
			}
			String passwordMd5=Md5Util.getMD5(userDto.getPassword());
			List<UserDto> list=jt.query(sql,new UserDto(),passwordMd5);
			if(list==null||list.size()==0){
				return null;
			}
			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	/**
	 * 注册新的系统用户
	 */
	public boolean regist(final UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql = null;
		if (userDto.getTelephone() != null
				&& !userDto.getTelephone().equals("")) {
			sql = "INSERT INTO system_user(telephone,user_password) VALUES('"
					+ userDto.getTelephone().trim() + "',?)";
		}
		if (userDto.getEmail() != null && !userDto.getEmail().equals("")) {
			sql = "INSERT INTO system_user(email,user_password) VALUES('"
					+ userDto.getEmail().trim() + "',?)";
		}
		int rows = jt.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement)
					throws SQLException {
				String passwordMd5=Md5Util.getMD5(userDto.getPassword());
				preparedStatement.setString(1, passwordMd5);				
			}
		});
		return rows>0;
	}

	@Override
	/**
	 * 通过用户id获得用户信息
	 */
	public UserDto getsystemUser(int userid) throws Exception {
		// TODO Auto-generated method stub
			JdbcTemplate jt=this.getJdbcTemplate();
			String sql = "SELECT * FROM SYSTEM_USER WHERE USER_ID=?";
			List<UserDto> list=jt.query(sql,new UserDto(),userid);
			if(list==null||list.size()==0){
				return null;
			}
			return list.get(0);		
	}

	@Override
	public boolean systemUserUpdate(final UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql = "UPDATE SYSTEM_USER SET USER_NAME=?,USER_PASSWORD=?,USER_IMG=?,TELEPHONE=?,EMAIL=? WHERE USER_ID=?";
		int rows = jt.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement)
					throws SQLException {
				preparedStatement.setString(1, userDto.getUserName());
				
				//判断密码是否改变。
					try {
						UserDto userDto2=getsystemUser(userDto.getUserId());
						if(!userDto2.getPassword().equals(userDto.getPassword())){
							String passwordMd5=Md5Util.getMD5(userDto.getPassword());
							preparedStatement.setString(2, passwordMd5);
						}else{
							preparedStatement.setString(2, userDto.getPassword());
						}		
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}										
				preparedStatement.setString(3, userDto.getUserImg());
				preparedStatement.setString(4, userDto.getTelephone());
				preparedStatement.setString(5, userDto.getEmail());
				preparedStatement.setInt(6, userDto.getUserId());						
			}

		});
		return rows>0;
	}	
}