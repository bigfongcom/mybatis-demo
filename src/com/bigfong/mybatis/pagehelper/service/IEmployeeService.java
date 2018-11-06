package com.bigfong.mybatis.pagehelper.service;

import com.bigfong.mybatis.pagehelper.query.QueryObject;
import com.github.pagehelper.PageInfo;


public interface IEmployeeService {
	
	
	PageInfo<?> query(QueryObject qo);
}
