package com.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDto implements RowMapper<UserDto>{

	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户性别
	 */
	private String userSex;
	/**
	 * 用户年龄
	 */
	private String userAge;
	/**
	 * 身份证号
	 */
	private String identificationCard;
	/**
	 * 用户图像
	 */
	private String userImg;
	/**
	 * 户籍所在地
	 */
	private String domicile;
	/**
	 * 用户现居地址
	 */
	private String address;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 职务编号
	 */
	private int dutyId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDto dto = new UserDto();
		dto.setUserId(rs.getInt("user_id"));
		dto.setUserName(rs.getString("user_name"));
		dto.setUserSex(rs.getString("user_sex"));
		dto.setAddress(rs.getString("address"));
		// dto.setDepartmentID(rs.getInt("department_id"));
		dto.setDomicile(rs.getString("domicile"));
		dto.setEmail(rs.getString("email"));
		dto.setIdentificationCard(rs.getString("identification_card"));
		dto.setUserAge(rs.getString("user_age"));
		dto.setUserImg(rs.getString("user_img"));
		dto.setDutyId(rs.getInt("duty_id"));
		dto.setTelephone(rs.getString("telephone"));
		dto.setPassword(rs.getString("user_password"));
		return dto;
	}

}
