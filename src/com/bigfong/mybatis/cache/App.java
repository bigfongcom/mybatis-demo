package com.bigfong.mybatis.cache;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.bigfong.mybatis.cache.domain.Teacher;
import com.bigfong.mybatis.cache.mapper.TeacherMapper;
import com.bigfong.mybatis.cache.util.MybatisUtil;

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
    void testGet() throws Exception { 
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper studentMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = studentMapper.get(50L);
        System.out.println(teacher);
        session.clearCache();//清空一级缓存
    }

    //二级缓存
    @Test
    void testSecondLevelCache() throws Exception { 
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper studentMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = studentMapper.get(50L);
        System.out.println(teacher);
        System.out.println("====================");
        session.close();
        
        session = MybatisUtil.getSession();
        studentMapper = session.getMapper(TeacherMapper.class);
        teacher = studentMapper.get(50L);
        System.out.println(teacher);
        session.close();
    }
}
