package com.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.jdbc.core.RowMapper;

public class DutyDto implements RowMapper<DutyDto>{

	/**
	 * 职务编号
	 */
	private int dutyId;
	/**
	 * 职务名称
	 */
	private String dutyName;
	/**
	 * 职务薪资
	 */
	private double dutySalary;
	/**
	 * 部门编号
	 */
	private int departmentId;
	private DepartmentDto departmentDto;

	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
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

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public static DutyDto fromPO(DutyDto dto) {
		DutyDto dto1 = new DutyDto();
		try {
			PropertyUtils.copyProperties(dto1, dto);
			return dto1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<DutyDto> fromList(List<DutyDto> oriList) {
		List<DutyDto> destList = new ArrayList<DutyDto>();
		for (DutyDto p : oriList) {
			destList.add(fromPO(p));
		}
		return destList;
	}

	@Override
	public DutyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DutyDto dto=new DutyDto();
		dto.setDepartmentId(rs.getInt("department_id"));
		//dto.setDepartmentName(rs.getString("department_name"));
		dto.setDutyId(rs.getInt("duty_id"));
		dto.setDutyName(rs.getString("duty_name"));
		dto.setDutySalary(rs.getDouble("duty_salary"));
		return dto;		
	}

}
