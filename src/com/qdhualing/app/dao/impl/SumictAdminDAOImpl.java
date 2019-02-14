package com.qdhualing.app.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qdhualing.app.dao.SumictAdminDAO;
import com.qdhualing.app.vo.SumictAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * SumictAdmin entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.qdhualing.app.dao.impl.SumictAdmin
 * @author MyEclipse Persistence Tools
 */

public class SumictAdminDAOImpl extends HibernateDaoSupport implements SumictAdminDAO{

	
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String LOGIN_TIME = "loginTime";
	public static final String LAST_LOGIN_TIME = "lastLoginTime";
	public static final String IP = "ip";
	public static final String ROLES = "roles";
	@Override
	public void attachClean(SumictAdmin instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachDirty(SumictAdmin instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SumictAdmin persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SumictAdmin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByCompanty(Object companty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByExample(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SumictAdmin findById(Integer id) {
		String hql = "from SumictAdmin where id=:id";
		return (SumictAdmin) getSession().createQuery(hql).setInteger("id",id).uniqueResult();
	}

	@Override
	public List<SumictAdmin> findByLabelid(Object labelid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByModel(Object model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByStatus(Object status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findByType(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SumictAdmin> findPageData(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDataCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SumictAdmin merge(SumictAdmin detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SumictAdmin transientInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SumictAdmin object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SumictAdmin login(String logiNname, String passWord) {
		
		String hql = "from SumictAdmin as sa where sa.userName = :logiNname and sa.password=:passWord";
		return  (SumictAdmin) getSession().createQuery(hql).setString("logiNname", logiNname).setString("passWord", passWord).uniqueResult();
	}

	@Override
	public SumictAdmin findByAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
