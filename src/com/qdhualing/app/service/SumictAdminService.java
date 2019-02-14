package com.qdhualing.app.service;

import com.qdhualing.app.vo.SumictAdmin;

public interface SumictAdminService extends CommonService<SumictAdmin> {

	SumictAdmin login(String logiNname, String passWord);
}
