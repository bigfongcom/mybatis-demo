package com.bigfong.mybatis.advancequery.mapper;

import java.util.List;

import com.bigfong.mybatis.advancequery.domain.Employee;
import com.bigfong.mybatis.advancequery.query.QueryObject;


public interface EmployeeMapper {
	
	List<Employee> queryForList(QueryObject qo);
	
	int queryForCount(QueryObject qo);
	
	
	List<Employee> listAll();
}
