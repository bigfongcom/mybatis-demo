package com.bigfong.mybatis.pagehelper.service.impl;

import java.util.List;

import com.bigfong.mybatis.pagehelper.mapper.EmployeeMapper;
import com.bigfong.mybatis.pagehelper.query.QueryObject;
import com.bigfong.mybatis.pagehelper.service.IEmployeeService;
import com.bigfong.mybatis.pagehelper.util.MybatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);

	public PageInfo<?> query(QueryObject qo) {
		PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
		List<?> list = employeeMapper.queryForList(qo);
		return new PageInfo<>(list);
	}

}
