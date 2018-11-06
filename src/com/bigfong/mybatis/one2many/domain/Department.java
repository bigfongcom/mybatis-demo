package com.bigfong.mybatis.one2many.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月3日 下午12:13:23
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Setter
@Getter
public class Department {
    private Long id;
    private String name;
    //一个部门关联多个员工
    private List<Employee> emps = new ArrayList<>();
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
    
}
