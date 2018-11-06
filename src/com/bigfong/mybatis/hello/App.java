package com.bigfong.mybatis.hello;

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

import com.bigfong.mybatis.hello.util.MybatisUtil;

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

    @Test
    void testLog() throws Exception {
        if (log.isInfoEnabled()) {
            log.info("银行转账操作");
        }

        if (log.isDebugEnabled()) {
            log.info("查询数据库");
        }

        if (log.isTraceEnabled()) {
            log.info("连接数据库");
        }

        if (log.isTraceEnabled()) {
            log.info("获取数据库对象");
        }

        if (log.isTraceEnabled()) {
            log.info("执行SQL");
        }

        if (log.isDebugEnabled()) {
            log.debug("转帐..debug.");
        }

        if (log.isDebugEnabled()) {
            log.info("银行转账成功");
        }
    }
    
    //添加
    @Test
    void testSave() throws Exception {     
        User user = new User();
        user.setName("小王子");
        user.setSalary(new BigDecimal("1024"));
        
        SqlSession session = MybatisUtil.getSession();
        session.insert("com.bigfong.mybatis.domain.UserMapper.save",user);
        //提交事务
        session.commit();
        session.close();
        System.out.println(user);
    }

    @Test
    void testGetCount() throws Exception {
        SqlSession session = MybatisUtil.getSession();
        int count = session.selectOne("com.bigfong.mybatis.domain.UserMapper.queryForCount");
        session.close();
        System.out.println("count:"+count);
    }
    
    @Test
    void testGet() throws Exception {
        // 1.从classpath路径中加载MyBatis全局配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config-hello.xml");
        // 2.创建SqlSessionFactory对象，好比是DataSource
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);
        // 3.创建SqlSession对象，好比是Connection
        SqlSession session = sessionFactory.openSession();
        // 4.具体的操作（增删改查）
        User user = session.selectOne("com.bigfong.mybatis.domain.UserMapper.get", 1L);
        // 5.关闭SqlSession
        session.close();
        System.out.println(user);
    }

    // 查询所有
    @Test
    void testListAll() throws Exception {

        SqlSession session = null;
        List<User> list;
        try {
            session = MybatisUtil.getSession();
            list = session.selectList("com.bigfong.mybatis.domain.UserMapper.listAll");
            System.out.println(list);
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // 关闭SqlSession
            if (session != null) {
                session.close();
            }
        }

    }
    
    // 查询所有
    @Test
    void testListAll2() throws Exception {
        try (SqlSession session = MybatisUtil.getSession();){          
            List<User> list = session.selectList("com.bigfong.mybatis.domain.UserMapper.listAll");
            System.out.println(list);
        }

    }
    
    // 查询所有
    @Test
    void testListAll3() throws Exception {
        @Cleanup
        SqlSession session = MybatisUtil.getSession();
        List<User> list = session.selectList("com.bigfong.mybatis.domain.UserMapper.listAll");
        System.out.println(list);

    }
    
    //修改
    @Test
    void testUpdate() throws Exception {     
        User user = new User();
        user.setName("七七2");
        user.setSalary(new BigDecimal("850"));
        user.setId(3L);
        
        SqlSession session = MybatisUtil.getSession();
        session.update("com.bigfong.mybatis.domain.UserMapper.update",user);
        //提交事务
        session.commit();
        session.close();
    }
    
    //删除
    @Test
    void testDelete() throws Exception {     
      
        SqlSession session = MybatisUtil.getSession();
        session.update("com.bigfong.mybatis.domain.UserMapper.delete",6L);
        //提交事务
        session.commit();
        session.close();
    }
    
    //查询部分字段
    @Test
    void testGetForMap() throws Exception {
        SqlSession session = MybatisUtil.getSession();
        Map map = session.selectOne("com.bigfong.mybatis.domain.UserMapper.getForMap", 2L);
        session.close();
        System.out.println(map);
    }
}
