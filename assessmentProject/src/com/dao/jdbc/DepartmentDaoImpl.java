package com.dao.jdbc;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dao.DepartmentDao;
import com.dto.DepartmentDto;

public class DepartmentDaoImpl extends JdbcDaoSupport implements DepartmentDao {

	@Override
	/**
	 * 查找满足条件的部门信息数量
	 */
	public int countDepartment(String msg) throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		//List<Object> listArgs=new ArrayList<Object>();
		String sql = "SELECT COUNT(*) AS C FROM department";
		if(msg!=null&&!msg.equals("")){
			sql=sql+" where department_name like '%"+msg+"%'";
		}
		@SuppressWarnings("deprecation")
		int count =jt.queryForInt(sql);
		return count;
	}

	@Override
	/**
	 * 查找所有的部门信息
	 */
	public List<DepartmentDto> selectAllDepartment(String msg, int offset,
			int length) throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt=this.getJdbcTemplate();
			List<Object> listArgs =new ArrayList<Object>();
			String sql = "select * from department ";
			if(msg!=null&&!msg.equals("")){
				sql=sql+" where department_name like '%"+msg+"%'";
			}
			sql += " order by department_id desc limit ?,?";
			listArgs.add(offset);
			listArgs.add(length);
			List<DepartmentDto> list=jt.query(sql,listArgs.toArray(),new DepartmentDto());	
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	/**
	 * 添加部门信息
	 */
	public boolean addDepartment(final DepartmentDto departmentDto)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			JdbcTemplate jt=this.getJdbcTemplate();
			String sql = "insert into department(department_name,department_count) VALUES(?,?)";
			int rows=jt.update(sql, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, departmentDto.getDepartmentName());
					ps.setInt(2, departmentDto.getDepartmentCount());
				}			
			});
			return rows>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	/**
	 * 删除部门信息
	 */
	public boolean deleteDepartment( int departmentId)
			throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql = "DELETE FROM department WHERE department_id=?";
		int rows=jt.update(sql, departmentId);
		return rows>0;
	}

	@Override
	/**
	 * 跟新部门信息
	 */
	public boolean updateDepartment(final DepartmentDto departmentDto)
			throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql = "UPDATE department SET department_name=?,department_count=? where department_id=?";
		
		int rows=jt.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, departmentDto.getDepartmentName());
				ps.setInt(2, departmentDto.getDepartmentCount());
				ps.setInt(3, departmentDto.getDepartmentId());
			}			
		});
		return rows>0;
	}

	@Override
	/**
	 * 通过部门id查询对应的部门信息
	 */
	public DepartmentDto selectDepartmentById( int departmentId)
			throws Exception {
		// TODO Auto-generated method stub
		JdbcTemplate jt=this.getJdbcTemplate();
		String sql = "select * from department where department_id=?";
		List<DepartmentDto> list=jt.query(sql,new DepartmentDto(), departmentId);
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
