package com.qdhualing.app.dao;

import com.qdhualing.app.vo.SumictAdmin;

public interface SumictAdminDAO extends CommonDao<SumictAdmin> {

	SumictAdmin login(String logiNname, String passWord);
}
