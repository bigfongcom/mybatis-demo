package com.bigfong.mybatis.pagehelper.mapper;

import java.util.List;

import com.bigfong.mybatis.pagehelper.domain.Employee;
import com.bigfong.mybatis.pagehelper.query.QueryObject;


/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年11月3日 下午10:15:40
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public interface EmployeeMapper {
    List<EmployeeMapper> queryForList(QueryObject qo);
    List<Employee> listAll();
}
