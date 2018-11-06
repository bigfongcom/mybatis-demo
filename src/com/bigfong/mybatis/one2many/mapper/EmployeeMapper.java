package com.bigfong.mybatis.one2many.mapper;

import java.util.List;

import com.bigfong.mybatis.one2many.domain.Employee;


/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月5日 上午11:54:17
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface EmployeeMapper {
    void save(Employee e);

    Employee get(long id);

    List<Employee> listAll();
}
