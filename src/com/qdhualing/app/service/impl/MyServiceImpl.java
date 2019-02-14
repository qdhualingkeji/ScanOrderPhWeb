package com.qdhualing.app.service.impl;

import java.util.List;

import com.qdhualing.app.service.MyService;

public class MyServiceImpl implements MyService {

	@Override
	public void attachClean(Object instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachDirty(Object instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object persistentInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByCompanty(Object companty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByExample(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByLabelid(Object labelid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByModel(Object model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByStatus(Object status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findByType(Object type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findPageData(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDataCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object merge(Object detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Object transientInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean valid(String username, String pass) {
		//此处只是简单测试故直接判断用户名密码
		if(username.equals("sunwenxiao")&&pass.equals("wenxiao795"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
