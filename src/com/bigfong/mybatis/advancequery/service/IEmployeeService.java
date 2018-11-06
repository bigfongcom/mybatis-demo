package com.bigfong.mybatis.advancequery.service;

import com.bigfong.mybatis.advancequery.query.PageResult;
import com.bigfong.mybatis.advancequery.query.QueryObject;

public interface IEmployeeService {
	PageResult query(QueryObject qo);
}
