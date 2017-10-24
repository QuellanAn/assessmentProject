package com.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dao.DutyDao;
import com.dto.DutyDto;
import com.dto.ManageDto;

public class DutyDaoImpl extends JdbcDaoSupport implements DutyDao {

	@Override
	/**
	 * 获得满足条件的职务信息的条数
	 */
	public int countDuty(int departmentId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "SELECT COUNT(*) AS C FROM duty ";
			if (departmentId != 0) {
				sql += " where department_id=" + departmentId + " ";
			}
			@SuppressWarnings("deprecation")
			int count = jt.queryForInt(sql);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	/**
	 * 获得满足条件的职务信息
	 */
	public List<ManageDto> selectDuty(int departmentId, int offset, int length)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			List<Object> listArgs = new ArrayList<Object>();
			String sql = "select d.department_id,duty_id,duty_name,d.department_name,duty_salary from duty left join department d on duty.department_id=d.department_id ";
			if (departmentId != 0) {
				sql += " where d.department_id=" + departmentId;
			}
			sql += " order by duty_id desc limit ?,?";
			listArgs.add(offset);
			listArgs.add(length);
			final List<ManageDto> list = new ArrayList<ManageDto>();

			jt.query(sql, listArgs.toArray(), new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					ManageDto dto = new ManageDto();
					dto.setDepartmentId(rs.getInt("department_id"));
					dto.setDepartmentName(rs.getString("department_name"));
					dto.setDutyId(rs.getInt("duty_id"));
					dto.setDutyName(rs.getString("duty_name"));
					dto.setDutySalary(rs.getDouble("duty_salary"));
					list.add(dto);
				}
			});
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * 添加新的职务信息
	 */
	public boolean addDuty(final DutyDto dutyDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "insert into duty(duty_name,duty_salary,department_id) VALUES(?,?,?)";
			int rows = jt.update(sql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, dutyDto.getDutyName());
					ps.setDouble(2, dutyDto.getDutySalary());
					ps.setInt(3, dutyDto.getDepartmentId());
				}
			});
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * 删除职务信息
	 */
	public boolean delete(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "DELETE FROM duty WHERE duty_id=?";
			int rows = jt.update(sql, dutyId);
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * 更新职务信息
	 */
	public boolean update(final DutyDto dutyDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "UPDATE duty SET duty_name=?,duty_salary=?,department_id=? where duty_id=?";
			int rows = jt.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, dutyDto.getDutyName());
					ps.setDouble(2, dutyDto.getDutySalary());
					ps.setInt(3, dutyDto.getDepartmentId());
					ps.setInt(4, dutyDto.getDutyId());
				}

			});
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * 通过职务id查找对应的职务信息
	 */
	public ManageDto selectDutyById(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "select d.department_id,duty_id,duty_name,d.department_name,duty_salary from duty left join department d on duty.department_id=d.department_id where duty_id=?";
			final List<ManageDto> list = new ArrayList<ManageDto>();

			jt.query(sql, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					ManageDto dto = new ManageDto();
					dto.setDepartmentId(rs.getInt("department_id"));
					dto.setDepartmentName(rs.getString("department_name"));
					dto.setDutyId(rs.getInt("duty_id"));
					dto.setDutyName(rs.getString("duty_name"));
					dto.setDutySalary(rs.getDouble("duty_salary"));
					list.add(dto);
				}
			}, dutyId);
			if (list == null || list.size() == 0) {
				return null;
			}
			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

}
