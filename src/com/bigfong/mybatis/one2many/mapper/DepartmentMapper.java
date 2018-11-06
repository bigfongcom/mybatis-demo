package com.bigfong.mybatis.one2many.mapper;

import com.bigfong.mybatis.one2many.domain.Department;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月5日 上午11:53:42
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface DepartmentMapper {
    void save(Department d);

    Department get(Long id);

    Department get2(Long id);
}
