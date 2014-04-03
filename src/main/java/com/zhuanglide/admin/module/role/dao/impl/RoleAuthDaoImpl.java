package com.zhuanglide.admin.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.role.dao.RoleAuthDao;
import com.zhuanglide.admin.module.role.entity.RoleAuth;
import com.zhuanglide.core.db.BaseDaoSupport;
@Repository("roleAuthDao")
public class RoleAuthDaoImpl extends BaseDaoSupport implements RoleAuthDao {

	private static final String SELECT_FILED = " id,role_id,auth_id " ;
	private static final String TABLE_NAME = " role_auth ";
	@Override
	public List<RoleAuth> selectList() throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY id";
		return this.getJdbcTemplate().query(sql, new RoleAuthRowMapp());
	}

	@Override
	public List<RoleAuth> selectListByRoleId(long roleId) throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " WHERE role_id=? ORDER BY id";
		return this.getJdbcTemplate().query(sql,new Object[]{roleId}, new RoleAuthRowMapp());
	}

	@Override
	public long insert(RoleAuth roleAuth) throws Exception {
		String sql = "INSERT INTO " + TABLE_NAME + " (role_id,auth_id ) VALUES (?,?)";
		int rs = this.getJdbcTemplate().update(sql,roleAuth.getRoleId(),roleAuth.getAuthId());
		if(rs<1){
			return -1L;
		}
		return this.getLastInsertId();
	}

	@Override
	public int update(RoleAuth roleAuth) throws Exception {
		String sql = "UPDATE " + TABLE_NAME + " SET role_id=?,auth_id=? WHERE id=?";
		return this.getJdbcTemplate().update(sql,roleAuth.getRoleId(),roleAuth.getAuthId(),roleAuth.getId());
	}

	@Override
	public int deleteById(long id) throws Exception {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
		return this.getJdbcTemplate().update(sql,id);
	}
	private class RoleAuthRowMapp implements RowMapper<RoleAuth>{
		@Override
		public RoleAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleAuth roleAuth = new RoleAuth();
			roleAuth.setId(rs.getLong("id"));
			roleAuth.setRoleId(rs.getLong("role_id"));
			roleAuth.setAuthId(rs.getLong("auth_id"));
			return roleAuth;
		}
		
	}
}
