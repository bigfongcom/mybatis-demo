package com.bigfong.mybatis.many2one.domain;

import java.math.BigDecimal;

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
public class Employee {
    private Long id;
    private String name;
    private Department dept;
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
