package com.bigfong.mybatis.one2many.domain;

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

@Data
public class Employee {
    private Long id;
    private String name;
    private Long deptId;//所在部门ID
   
}
