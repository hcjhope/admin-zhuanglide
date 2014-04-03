package com.zhuanglide.admin.module.role.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhuanglide.admin.module.role.dao.UserRoleDao;
import com.zhuanglide.admin.module.role.entity.UserRole;
import com.zhuanglide.core.db.BaseDaoSupport;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoSupport implements UserRoleDao {
	private static final String SELECT_FILED = " id,user_id,group_id,role_id,operator_id,create_time " ;
	private static final String TABLE_NAME = " role_group ";
	
	@Override
	public List<UserRole> selectList() throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " ORDER BY group_id,id";
		return this.getJdbcTemplate().query(sql, new UserRoleRowMapp());
	}

	
	@Override
	public List<UserRole> selectListByUserId(long userId) throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " WHERE user_id=? ORDER BY group_id,id";
		return this.getJdbcTemplate().query(sql, new UserRoleRowMapp(),userId);
	}


	@Override
	public UserRole selectById(long id) throws Exception {
		String sql = "SELECT " + SELECT_FILED + " FROM " + TABLE_NAME + " WHERE id=?";
		return this.getJdbcTemplate().queryForObject(sql,new UserRoleRowMapp(),id);
	}

	@Override
	public long insert(UserRole userRole) throws Exception {
		String sql = "INSERT INTO " + TABLE_NAME + " (user_id,group_id,role_id,operator_id,create_time) VALUES(?,?,?,?,?)";
		int rs = this.getJdbcTemplate().update(sql, userRole.getUserId(),userRole.getGroupId(),userRole.getRoleId(),userRole.getOperatorId(),new Date());
		if(rs<1){
			return -1L;
		}
		return this.getLastInsertId();	}

	@Override
	public int update(UserRole userRole) throws Exception {
		String sql = "UPDATE " + TABLE_NAME + " SET user_id=?,group_id=?,role_id=?,operator_id=? WHERE id=?";
		return this.getJdbcTemplate().update(sql, userRole.getUserId(),userRole.getGroupId(),userRole.getRoleId(),userRole.getOperatorId(),userRole.getId());
	}

	@Override
	public int delete(long id) throws Exception {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
		return this.getJdbcTemplate().update(sql, id);
	}

	private class UserRoleRowMapp implements RowMapper<UserRole>{
		@Override
		public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserRole userRole = new UserRole();
			userRole.setId(rs.getLong("id"));
			userRole.setUserId(rs.getLong("user_id"));
			userRole.setGroupId(rs.getLong("group_id"));
			userRole.setRoleId(rs.getLong("role_id"));
			userRole.setOperatorId(rs.getLong("operator_id"));
			Timestamp createTime = rs.getTimestamp("create_time");
			userRole.setCreateTime(null==createTime?null:new Date(createTime.getTime()));
			return userRole;
		}
		
	}
}
