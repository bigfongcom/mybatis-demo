package com.bigfong.mybatis.dynamicsql;

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

import com.bigfong.mybatis.dynamicsql.domain.Employee;
import com.bigfong.mybatis.dynamicsql.mapper.EmployeeMapper;
import com.bigfong.mybatis.dynamicsql.util.MybatisUtil;

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
        Employee user = new Employee();
        user.setName("王小子2");
        user.setSalary(new BigDecimal("3024"));
        
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        userMapper.save(user);
        //提交事务
        session.commit();
        session.close();
        System.out.println(user);
    }

    
    @Test
    void testGet() throws Exception {

        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        Employee user = userMapper.get(1L);
        session.close();
        System.out.println(user);
    }

    // 查询所有
    @Test
    void testListAll() throws Exception {

        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = userMapper.listAll();
        session.close();
        System.out.println(list);

    }

    
    //修改
    @Test
    void testUpdate() throws Exception {     
        Employee user = new Employee();
        user.setName("七七3333");
        user.setSalary(new BigDecimal("123"));
        user.setId(3L);
        
        SqlSession session = MybatisUtil.getSession();      
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        userMapper.update(user);        
        //提交事务
        session.commit();
        session.close();
    }
    
    //删除
    @Test
    void testDelete() throws Exception {     
      
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        userMapper.delete(10L);
        //提交事务
        session.commit();
        session.close();
    }

}
