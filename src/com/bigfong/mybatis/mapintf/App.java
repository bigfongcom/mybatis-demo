package com.bigfong.mybatis.mapintf;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.bigfong.mybatis.mapintf.domain.User;
import com.bigfong.mybatis.mapintf.domain.mapper.UserMapper;
import com.bigfong.mybatis.mapintf.util.MybatisUtil;

import lombok.Cleanup;

/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年11月3日 下午4:33:16
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public class App {
    private static Logger log = Logger.getLogger(App.class);
    // 查询单个
    //Mapper接口的原理：动态代理，代理对像为com.sun.proxy.$Proxy9
    @Test
    void testGet() throws Exception {
        SqlSession session = MybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        System.out.println(userMapper.getClass());
        User user = userMapper.get(1L);
        session.close();
        System.out.println(user);
    }
    
 // 查询所有
    @Test
    void testListAll() throws Exception {
        SqlSession session = MybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.listAll();
        session.close();
        System.out.println(list);
    }
}
