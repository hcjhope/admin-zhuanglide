package com.zhuanglide.core.db;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDaoSupport extends JdbcDaoSupport{

	@Resource(name="dataSource")
	@Override
	protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return super.createJdbcTemplate(dataSource);
	}
	
	public Long getLastInsertId(){
		String sql ="select last_insert_id()";
		return getJdbcTemplate().queryForLong(sql);
	}
}
