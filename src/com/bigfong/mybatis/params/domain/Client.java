package com.bigfong.mybatis.params.domain;

import lombok.Data;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月3日 下午12:13:23
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Data
public class Client {
    private Long id;
    private String username;
    private String password;
}
