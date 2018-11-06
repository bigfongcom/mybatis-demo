package com.bigfong.mybatis.many2one.mapper;

import com.bigfong.mybatis.many2one.domain.Department;

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
}
