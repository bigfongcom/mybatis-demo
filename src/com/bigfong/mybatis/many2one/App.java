package com.bigfong.mybatis.many2one;

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


import com.bigfong.mybatis.many2one.domain.Department;
import com.bigfong.mybatis.many2one.domain.Employee;
import com.bigfong.mybatis.many2one.mapper.DepartmentMapper;
import com.bigfong.mybatis.many2one.mapper.EmployeeMapper;
import com.bigfong.mybatis.many2one.util.MybatisUtil;

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

   
    //保存一个部门和两个员工
    @Test
    void testSave() throws Exception { 
        Department department = new Department();
        department.setName("开发部");
        
        Employee user1 = new Employee();
        user1.setName("王小子2");
        user1.setDept(department);//维护对象关系
        
        Employee user2 = new Employee();
        user2.setName("兰兰");
        user2.setDept(department);//维护对象关系
        
        SqlSession session = MybatisUtil.getSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        
        departmentMapper.save(department);
        userMapper.save(user1);
        userMapper.save(user2);
        //提交事务
        session.commit();
        session.close();
        System.out.println(department);
        System.out.println(user1);
        System.out.println(user2);
    }

    
   @Test
    void testGet() throws Exception {

        SqlSession session = MybatisUtil.getSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
        
        Employee user = userMapper.get(1L);
        /*
        Department dept = departmentMapper.get(user.getDept().getId());
        user.setDept(dept);
        */
        session.close();
        System.out.println(user);
        System.out.println(user.getDept());
    }

   @Test
   void testListAll() throws Exception {

       SqlSession session = MybatisUtil.getSession();
       EmployeeMapper userMapper = session.getMapper(EmployeeMapper.class);
    
       List<Employee> list = userMapper.listAll();
 
       session.close();
       for(Employee e:list) {
           System.out.println(e);
           System.out.println(e.getDept());
       }
       
   }
}
