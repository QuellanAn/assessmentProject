package com.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.jdbc.core.RowMapper;

public class DepartmentDto implements RowMapper<DepartmentDto>{
	/**
	 * 部门id
	 */
	private int departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部门人数
	 */
	private int departmentCount;

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

	public static DepartmentDto fromPO(DepartmentDto dto) {
		DepartmentDto dto1 = new DepartmentDto();
		try {
			PropertyUtils.copyProperties(dto1, dto);
			return dto1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<DepartmentDto> fromList(List<DepartmentDto> oriList) {
		List<DepartmentDto> destList = new ArrayList<DepartmentDto>();
		for (DepartmentDto p : oriList) {
			destList.add(fromPO(p));
		}
		return destList;
	}

	@Override
	public DepartmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DepartmentDto dto = new DepartmentDto();
		dto.setDepartmentId(rs.getInt("department_id"));
		dto.setDepartmentName(rs.getString("department_name"));
		dto.setDepartmentCount(rs.getInt("department_count"));
		return dto;
	}
}
