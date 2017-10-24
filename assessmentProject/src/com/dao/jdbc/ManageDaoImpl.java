package com.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.dao.ManageDao;
import com.dto.DepartmentDto;
import com.dto.DutyDto;
import com.dto.ManageDto;
import com.dto.UserDto;

public class ManageDaoImpl extends JdbcDaoSupport implements ManageDao {

	@Override
	/**
	 * 选择所有的部门信息
	 */
	public List<DepartmentDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "select * from department";
			List<DepartmentDto> list = jt.query(sql, new DepartmentDto());
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * 查找部门的所以职务信息
	 */
	public List<DutyDto> selectByDepartment(int departmentId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "select * from duty where department_id=?";
			List<DutyDto> list = jt.query(sql, new DutyDto(), departmentId);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * 通过查询条件获得满足条件的用户信息
	 */
	public List<ManageDto> selectByMsg(ManageDto manageDto, int offset,
			int length) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			// List<Object> listArgs=new ArrayList<Object>();
			StringBuilder sql = new StringBuilder(
					"SELECT USER_ID,USER_NAME,USER_PASSWORD,USER_SEX,USER_AGE,USER_IMG,IDENTIFICATION_CARD,DOMICILE,ADDRESS,TELEPHONE,EMAIL, "
							+ "DP.DEPARTMENT_NAME,DP.DEPARTMENT_COUNT,D.DUTY_NAME,D.DUTY_SALARY,D.DEPARTMENT_ID,U.DUTY_ID  "
							+ "FROM USER U LEFT JOIN DUTY D ON U.DUTY_ID=D.DUTY_ID "
							+ "LEFT JOIN DEPARTMENT DP ON DP.DEPARTMENT_ID=D.DEPARTMENT_ID "
							+ " where 1=1 ");

			// 连接查询条件
			// 姓名
			if (manageDto.getUserName() != null
					&& !manageDto.getUserName().equals("")) {
				sql.append(" AND USER_NAME LIKE '%" + manageDto.getUserName()
						+ "%'");
			}
			// 电话
			if (manageDto.getTelephone() != null
					&& !manageDto.getTelephone().equals("")) {
				sql.append(" AND TELEPHONE LIKE '%" + manageDto.getTelephone()
						+ "%'");
			}
			// 邮箱
			if (manageDto.getEmail() != null
					&& !manageDto.getEmail().equals("")) {
				sql.append(" AND EMAIL LIKE '%" + manageDto.getEmail() + "%'");
			}
			// 身份证
			if (manageDto.getIdentificationCard() != null
					&& !manageDto.getIdentificationCard().equals("")) {
				sql.append(" AND IDENTIFICATION_CARD LIKE '%"
						+ manageDto.getIdentificationCard() + "%'");
			}
			// 性别
			if (manageDto.getUserSex() != null
					&& !manageDto.getUserSex().equals("")) {
				sql.append(" AND USER_SEX LIKE '%" + manageDto.getUserSex()
						+ "%'");
			}
			// 部门
			if (manageDto.getDepartmentId() != 0) {
				sql.append(" AND DP.DEPARTMENT_ID ="
						+ manageDto.getDepartmentId());
			}
			// 职位
			if (manageDto.getDutyId() != 0) {
				sql.append(" AND D.DUTY_ID =" + manageDto.getDutyId());
			}
			sql.append(" order by USER_ID desc limit ?,?");
			List<ManageDto> list = jt.query(sql.toString(), new ManageDto(),
					offset, length);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * 查找满足条件的数据条数
	 */
	public int countSelectByMsg(ManageDto manageDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(*) AS C FROM USER U LEFT JOIN DUTY D ON U.DUTY_ID=D.DUTY_ID LEFT JOIN DEPARTMENT DP ON DP.DEPARTMENT_ID=D.DEPARTMENT_ID WHERE 1=1 ");
			// 连接查询条件
			// 姓名
			if (manageDto.getUserName() != null
					&& !manageDto.getUserName().equals("")) {
				sql.append(" AND USER_NAME LIKE '%" + manageDto.getUserName()
						+ "%'");
			}
			// 电话
			if (manageDto.getTelephone() != null
					&& !manageDto.getTelephone().equals("")) {
				sql.append(" AND TELEPHONE LIKE '%" + manageDto.getTelephone()
						+ "%'");
			}
			// 邮箱
			if (manageDto.getEmail() != null
					&& !manageDto.getEmail().equals("")) {
				sql.append(" AND EMAIL LIKE '%" + manageDto.getEmail() + "%'");
			}
			// 身份证
			if (manageDto.getIdentificationCard() != null
					&& !manageDto.getIdentificationCard().equals("")) {
				sql.append(" AND IDENTIFICATION_CARD LIKE '%"
						+ manageDto.getIdentificationCard() + "%'");
			}
			// 性别
			if (manageDto.getUserSex() != null
					&& !manageDto.getUserSex().equals("")) {
				sql.append(" AND USER_SEX LIKE '%" + manageDto.getUserSex()
						+ "%'");
			}
			// 部门
			if (manageDto.getDepartmentId() != 0) {
				sql.append(" AND DP.DEPARTMENT_ID ="
						+ manageDto.getDepartmentId());
			}
			// 职位
			if (manageDto.getDutyId() != 0) {
				sql.append(" AND D.DUTY_ID =" + manageDto.getDutyId());
			}
			@SuppressWarnings("deprecation")
			int count = jt.queryForInt(sql.toString());
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	/**
	 * 删除用户信息
	 */
	public boolean deleteUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "DELETE FROM USER WHERE USER_ID=?";
			int rows = jt.update(sql, userId);
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * 更新用户信息
	 */
	public boolean updateUser(final ManageDto manageDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "UPDATE USER SET USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_AGE=?,USER_IMG=?,IDENTIFICATION_CARD=?,DOMICILE=?,ADDRESS=?,TELEPHONE=?,EMAIL=?,DUTY_ID=? WHERE USER_ID=?";
			int rows = jt.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, manageDto.getUserName());
					//判断密码是否改变。
					try {
						ManageDto manageDto2=getUserMsgById(manageDto.getUserId());
						if(!manageDto2.getPassword().equals(manageDto.getPassword())){
							String passwordMd5=Md5Util.getMD5(manageDto.getPassword());
							ps.setString(2, passwordMd5);
						}else{
							ps.setString(2, manageDto.getPassword());
						}		
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					//ps.setString(2, manageDto.getPassword());
					ps.setString(3, manageDto.getUserSex());
					ps.setString(4, manageDto.getUserAge());
					ps.setString(5, manageDto.getUserImg());
					ps.setString(6, manageDto.getIdentificationCard());
					ps.setString(7, manageDto.getDomicile());
					ps.setString(8, manageDto.getAddress());
					ps.setString(9, manageDto.getTelephone());
					ps.setString(10, manageDto.getEmail());
					ps.setInt(11, manageDto.getDutyId());
					ps.setInt(12, manageDto.getUserId());
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
	 * 通过用户id获得对应的用户信息
	 */
	public ManageDto getUserMsgById(int userId) throws Exception {
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "SELECT USER_ID,USER_NAME,USER_PASSWORD,USER_SEX,USER_AGE,USER_IMG,IDENTIFICATION_CARD,DOMICILE,ADDRESS,TELEPHONE,EMAIL, "
					+ "DP.DEPARTMENT_NAME,DP.DEPARTMENT_COUNT,D.DUTY_NAME,D.DUTY_SALARY,D.DEPARTMENT_ID,U.DUTY_ID  "
					+ "FROM USER U LEFT JOIN DUTY D ON U.DUTY_ID=D.DUTY_ID "
					+ "LEFT JOIN DEPARTMENT DP ON DP.DEPARTMENT_ID=D.DEPARTMENT_ID "
					+ " WHERE USER_ID=?";
			List<ManageDto> list = jt.query(sql, new ManageDto(), userId);
			if (list == null || list.size() == 0) {
				return null;
			}
			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
	}

	@Override
	/**
	 * 添加的新的用户
	 */
	public boolean addUser(final ManageDto manageDto) throws Exception {
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "INSERT INTO USER(USER_NAME,USER_PASSWORD,USER_SEX,USER_AGE,USER_IMG,IDENTIFICATION_CARD,DOMICILE,ADDRESS,TELEPHONE,EMAIL,DUTY_ID) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			int rows = jt.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, manageDto.getUserName().trim());
					String passwordMd5=Md5Util.getMD5(manageDto.getPassword().trim());
					ps.setString(2, passwordMd5);	
					//ps.setString(2, manageDto.getPassword().trim());
					ps.setString(3, manageDto.getUserSex().trim());
					ps.setString(4, manageDto.getUserAge().trim());
					ps.setString(5, manageDto.getUserImg().trim());
					ps.setString(6, manageDto.getIdentificationCard().trim());
					ps.setString(7, manageDto.getDomicile().trim());
					ps.setString(8, manageDto.getAddress().trim());
					ps.setString(9, manageDto.getTelephone().trim());
					ps.setString(10, manageDto.getEmail().trim());
					ps.setInt(11, manageDto.getDutyId());
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
	 * 通过职务id获得对应的薪资
	 */
	public ManageDto getSalary(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "SELECT DUTY_SALARY FROM DUTY WHERE DUTY_ID=?";
			final List<ManageDto> list = new ArrayList<ManageDto>();
			jt.query(sql, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					ManageDto dto = new ManageDto();
					dto.setDutySalary(rs.getDouble("DUTY_SALARY"));
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
		/*	*/

	}

	@Override
	/**
	 * 通过部门id修改其部门人数
	 */
	public boolean updateDepartmentCount(int departmentId, int count)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "UPDATE DEPARTMENT SET DEPARTMENT_COUNT=? WHERE DEPARTMENT_ID=?";
			int rows = jt.update(sql,count,departmentId);
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int selectDepartmentCount(int departmentId) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt = this.getJdbcTemplate();
			String sql = "SELECT DEPARTMENT_COUNT FROM DEPARTMENT WHERE DEPARTMENT_ID=?";
			@SuppressWarnings("deprecation")
			int count = jt.queryForInt(sql, departmentId);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int departmentCountByDutyId(int dutyId) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql="select count(*) from user where duty_id=?";
		@SuppressWarnings("deprecation")
		int count=jt.queryForInt(sql, dutyId);
		return count;		
	}
	

}
