package com.bigfong.mybatis.pagehelper.domain;

import java.math.BigDecimal;

import lombok.Data;

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
    private String sn;
    private BigDecimal salary;
    private Long deptId;
}
