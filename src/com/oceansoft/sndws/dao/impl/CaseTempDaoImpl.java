package com.oceansoft.sndws.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oceansoft.sndws.dao.ICaseTempDao;

@Repository
public class CaseTempDaoImpl implements ICaseTempDao{

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jt;
	
	@Override
	public boolean copyFromViewListToTemp(String caseId) {
		jt.execute("{call COPYTO_TEMPCASELIST('"+caseId+"')}");
		return true;
	}

}
