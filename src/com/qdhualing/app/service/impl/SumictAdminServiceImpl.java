package com.qdhualing.app.service.impl;

import java.util.List;

import com.qdhualing.app.dao.SumictAdminDAO;
import com.qdhualing.app.service.SumictAdminService;
import com.qdhualing.app.vo.SumictAdmin;

public class SumictAdminServiceImpl implements SumictAdminService{

	private SumictAdminDAO sumictAdminDAO;
	public void setSumictAdminDAO(SumictAdminDAO sumictAdminDAO) {
		this.sumictAdminDAO = sumictAdminDAO;
	}

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
		
		return sumictAdminDAO.findById(id);
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
	
		return sumictAdminDAO.login(logiNname, passWord);
	}

}
