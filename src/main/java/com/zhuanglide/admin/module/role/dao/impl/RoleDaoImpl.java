package com.zhuanglide.admin.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.role.dao.RoleDao;
import com.zhuanglide.admin.module.role.entity.Role;
import com.zhuanglide.core.db.BaseDaoSupport;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoSupport implements RoleDao{

	private static final String SELECT_FILED = " id,group_id,role_name,role_desc,create_time " ;
	private static final String TABLE_NAME = " role ";
	@Override
	public List<Role> selectList() throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY group_id,id";
		return this.getJdbcTemplate().query(sql, new RoleRowMapp());
	}

	@Override
	public List<Role> selectListByGroupId(long groupId) throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " WHERE group_id=?  ORDER BY id";
		return this.getJdbcTemplate().query(sql, new Object[]{groupId},new RoleRowMapp());
	}

	@Override
	public long insert(Role role) throws Exception {
		String insertSql = "INSERT INTO "+TABLE_NAME+" (group_id,role_name,role_desc,create_time) VALUES (?,?,?,?)"; 
		int rs = this.getJdbcTemplate().update(insertSql, role.getGroupId(),role.getRoleName(),role.getRoleDesc(),new Date());
		if(rs<1){
			return -1L;
		}
		return this.getLastInsertId();
	}

	@Override
	public int updateById(Role role) throws Exception {
		String updateSql = "UPDATE "+TABLE_NAME+" SET group_id=?,role_name=?,role_desc=?  WHERE id=?"; 
		return this.getJdbcTemplate().update(updateSql, role.getGroupId(),role.getRoleName(),role.getRoleDesc(),role.getId());
	}

	@Override
	public int deleteById(long id) throws Exception {
		String updateSql = "DELETE FROM "+TABLE_NAME+" WHERE id=?"; 
		return this.getJdbcTemplate().update(updateSql, id);
	}
	
	private class RoleRowMapp implements RowMapper<Role>{
		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setId(rs.getLong("id"));
			role.setGroupId(rs.getLong("group_id"));
			role.setRoleName(rs.getString("role_name"));
			role.setRoleDesc(rs.getString("role_desc"));
			role.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
			return role;
		}
		
	}
}
