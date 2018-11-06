package com.bigfong.mybatis.params.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bigfong.mybatis.params.LoginVo;
import com.bigfong.mybatis.params.domain.Client;

/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年11月3日 下午10:15:40
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public interface ClientMapper {
    // 方式一：把多个参数封状
    Client login1(LoginVo vo);

    // 方式二：使用map参数封装
    Client login2(Map vo);

    // 方式三：使用Param注解 参数封装,原理是方式二，Param注解中的字符串表示在Map中的Key
    Client login3(@Param("username") String username, @Param("password") String password);
}
