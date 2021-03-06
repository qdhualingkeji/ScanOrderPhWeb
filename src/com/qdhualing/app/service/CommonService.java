package com.qdhualing.app.service;

import java.util.List;

public interface CommonService<T> {
	void attachClean(T instance);

	void attachDirty(T instance);

	void delete(Integer id);

	void delete(T persistentInstance);

	List<T> findAll();

	List<T> findByCompanty(Object companty);

	List<T> findByExample(Object instance);

	T findById(java.lang.Integer id);

	List<T> findByLabelid(Object labelid);

	List<T> findByModel(Object model);

	List<T> findByProperty(String propertyName, Object value);

	List<T> findByStatus(Object status);

	List<T> findByType(Object type);

	List<T> findPageData(int pageNo, int pageSize);
	
	int getDataCount();

	T merge(T detachedInstance);

	void save(T transientInstance);

	void update(T object);

}
