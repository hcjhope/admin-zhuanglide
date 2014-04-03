package com.zhuanglide.admin.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.role.dao.RoleGroupDao;
import com.zhuanglide.admin.module.role.entity.RoleGroup;
import com.zhuanglide.core.db.BaseDaoSupport;
@Repository("roleGroupDao")
public class RoleGroupDaoImpl extends BaseDaoSupport implements RoleGroupDao {

	private static final String SELECT_FILED = " id,group_name,group_desc " ;
	private static final String TABLE_NAME = " role_group ";
	
	@Override
	public List<RoleGroup> selectList() throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY id";
		return this.getJdbcTemplate().query(sql, new RoleGroupRowMapp());
	}

	@Override
	public RoleGroup selectById(long id) throws Exception{
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY id";
		return this.getJdbcTemplate().queryForObject(sql,new RoleGroupRowMapp() ,id);
	}

	@Override
	public long insert(RoleGroup roleGroup) throws Exception {
		String sql = "INSERT INTO " + TABLE_NAME + " (group_name,group_desc ) VALUES (?,?)";
		int rs = this.getJdbcTemplate().update(sql, roleGroup.getGroupName(),roleGroup.getGroupDesc());
		if(rs<1){
			return -1L;
		}
		return this.getLastInsertId();
	}

	@Override
	public int update(RoleGroup roleGroup) throws Exception {
		String sql = "UPDATE " + TABLE_NAME + " SET group_name=?,group_desc=? WHERE id=?";
		return this.getJdbcTemplate().update(sql, roleGroup.getGroupName(),roleGroup.getGroupDesc(),roleGroup.getId());
	}

	@Override
	public int delete(long id) throws Exception{
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
		return this.getJdbcTemplate().update(sql, id);
	}
	
	private class RoleGroupRowMapp implements RowMapper<RoleGroup>{
		@Override
		public RoleGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleGroup roleAuth = new RoleGroup();
			roleAuth.setId(rs.getLong("id"));
			roleAuth.setGroupName(rs.getString("group_name"));
			roleAuth.setGroupDesc(rs.getString("group_desc"));
			return roleAuth;
		}
		
	}

}
