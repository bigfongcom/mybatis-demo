package com.bigfong.mybatis.many2many.domain;

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
public class Teacher {
    private Long id;
    private String name;
    
    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
}
