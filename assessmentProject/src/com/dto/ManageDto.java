package com.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.jdbc.core.RowMapper;

public class ManageDto implements RowMapper<ManageDto>{

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
	 * 用户所在省份
	 */
	private String address1;
	/**
	 * 用户所在市区
	 */
	private String address2;
	/**
	 * 用户详细地址
	 */
	private String address3;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 部门编号
	 */
	private int departmentId;
	/**
	 * 部门命名称
	 */
	private String departmentName;
	/**
	 * 部门人数
	 */
	private int departmentCount;
	/**
	 * 职务名称
	 */
	private String dutyName;
	/**
	 * 职务薪资
	 */
	private double dutySalary;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentCount() {
		return departmentCount;
	}

	public void setDepartmentCount(int departmentCount) {
		this.departmentCount = departmentCount;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public double getDutySalary() {
		return dutySalary;
	}

	public void setDutySalary(double dutySalary) {
		this.dutySalary = dutySalary;
	}

	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}

	public static ManageDto fromPO(ManageDto dto) {
		ManageDto dto1 = new ManageDto();
		try {
			PropertyUtils.copyProperties(dto1, dto);
			return dto1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<ManageDto> fromList(List<ManageDto> oriList) {
		List<ManageDto> destList = new ArrayList<ManageDto>();
		for (ManageDto p : oriList) {
			destList.add(fromPO(p));
		}
		return destList;
	}

	@Override
	public ManageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ManageDto dto=new ManageDto();

		dto.setUserId(rs.getInt("user_id"));
		dto.setUserName(rs.getString("user_name"));
		//System.out.println(rs.findColumn("user_name"));
		
		//System.out.println("userName:"+rs.getInt("user_name"));
		//System.out.println("domicile:"+rs.getString("domicile"));
		
		/*if(rs.findColumn("user_name")!=-1){
			dto.setUserName(rs.getString("user_name"));
		};*/
		
		//System.out.println("111111111"+rs.getString("user_sex"));
		if(rs.getString("user_sex")!=null&&!rs.getString("user_sex").equals("")){
			if(rs.getString("user_sex").equals("1")){
				dto.setUserSex("男");
			}else if(rs.getString("user_sex").equals("2")){
				dto.setUserSex("女");
			}else {
				dto.setUserSex(rs.getString("user_sex"));
			}	
		}			
		dto.setAddress(rs.getString("address"));			
		dto.setDomicile(rs.getString("domicile"));
		dto.setEmail(rs.getString("email"));
		dto.setIdentificationCard(rs.getString("identification_card"));
		dto.setUserAge(rs.getString("user_age"));
		dto.setUserImg(rs.getString("user_img"));
		dto.setTelephone(rs.getString("telephone"));
		dto.setPassword(rs.getString("user_password"));
		
		dto.setDutyId(rs.getInt("DUTY_ID"));
		dto.setDutyName(rs.getString("DUTY_NAME"));
		dto.setDutySalary(rs.getDouble("DUTY_SALARY"));
		
		dto.setDepartmentId(rs.getInt("department_id"));
		dto.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
		dto.setDepartmentCount(rs.getInt("DEPARTMENT_COUNT"));
		return dto;
	}
}
