package com.zhuanglide.admin.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.role.dao.AuthDao;
import com.zhuanglide.admin.module.role.entity.Auth;
import com.zhuanglide.core.db.BaseDaoSupport;

@Repository("autheDao")
public class AuthDaoImpl extends BaseDaoSupport implements AuthDao{

	private static final String SELECT_FILED = " id,auth_name,auth_url,auth_desc " ;
	private static final String TABLE_NAME = " auth ";
	@Override
	public List<Auth> selectList() throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY id";
		return this.getJdbcTemplate().query(sql, new AuthRowMapp());
	}


	@Override
	public long insert(Auth auth) throws Exception {
		String insertSql = "INSERT INTO "+TABLE_NAME+" (auth_name,auth_url,auth_desc) VALUES (?,?,?)"; 
		int rs = this.getJdbcTemplate().update(insertSql, auth.getAuthName(),auth.getAuthUrl(),auth.getAuthDesc());
		if(rs<1){
			return -1L;
		}
		return this.getLastInsertId();
	}

	@Override
	public int updateById(Auth auth) throws Exception {
		String updateSql = "UPDATE "+TABLE_NAME+" SET auth_name=?,auth_url=?,auth_desc=?  WHERE id=?"; 
		return this.getJdbcTemplate().update(updateSql, auth.getAuthName(),auth.getAuthUrl(),auth.getAuthDesc(),auth.getId());
	}

	@Override
	public int deleteById(long id) throws Exception {
		String updateSql = "DELETE FROM "+TABLE_NAME+" WHERE id=?"; 
		return this.getJdbcTemplate().update(updateSql, id);
	}
	
	private class AuthRowMapp implements RowMapper<Auth>{
		@Override
		public Auth mapRow(ResultSet rs, int rowNum) throws SQLException {
			Auth auth = new Auth();
			auth.setId(rs.getLong("id"));
			auth.setAuthName(rs.getString("auth_name"));
			auth.setAuthUrl(rs.getString("auth_url"));
			auth.setAuthDesc(rs.getString("auth_desc"));
			return auth;
		}
		
	}
}
