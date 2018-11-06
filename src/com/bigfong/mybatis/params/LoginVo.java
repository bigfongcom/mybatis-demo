package com.bigfong.mybatis.params;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月4日 下午6:16:46
* @revision      $Id: 1.0  
*   
***********************************************************************/
//封装登陆信息
@AllArgsConstructor
@Getter
public class LoginVo {
    private String username;
    private String password;
}
