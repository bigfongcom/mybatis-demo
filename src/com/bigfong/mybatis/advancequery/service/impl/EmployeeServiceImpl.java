package com.bigfong.mybatis.advancequery.service.impl;

import java.util.Collections;
import java.util.List;

import com.bigfong.mybatis.advancequery.domain.Employee;
import com.bigfong.mybatis.advancequery.mapper.EmployeeMapper;
import com.bigfong.mybatis.advancequery.query.PageResult;
import com.bigfong.mybatis.advancequery.query.QueryObject;
import com.bigfong.mybatis.advancequery.service.IEmployeeService;
import com.bigfong.mybatis.advancequery.util.MybatisUtil;



public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);

	public PageResult query(QueryObject qo) {
		int rows = employeeMapper.queryForCount(qo);
		if (rows == 0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> result = employeeMapper.queryForList(qo);
		return new PageResult(result, rows, qo.getCurrentPage(), qo.getPageSize());
	}


}
