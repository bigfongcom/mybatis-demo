package com.bigfong.mybatis.anno;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.bigfong.mybatis.anno.domain.User;
import com.bigfong.mybatis.anno.mapper.UserMapper;
import com.bigfong.mybatis.anno.util.MybatisUtil;

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

   
    //添加
    @Test
    void testSave() throws Exception {     
        User user = new User();
        user.setName("王小子2");
        user.setSalary(new BigDecimal("3024"));
        
        SqlSession session = MybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.save(user);
        //提交事务
        session.commit();
        session.close();
        System.out.println(user);
    }

    
    @Test
    void testGet() throws Exception {

        SqlSession session = MybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
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

    
    //修改
    @Test
    void testUpdate() throws Exception {     
        User user = new User();
        user.setName("七七3333");
        user.setSalary(new BigDecimal("123"));
        user.setId(3L);
        
        SqlSession session = MybatisUtil.getSession();      
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.update(user);        
        //提交事务
        session.commit();
        session.close();
    }
    
    //删除
    @Test
    void testDelete() throws Exception {     
      
        SqlSession session = MybatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.delete(10L);
        //提交事务
        session.commit();
        session.close();
    }

}
