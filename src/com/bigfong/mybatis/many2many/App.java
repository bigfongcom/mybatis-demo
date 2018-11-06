package com.bigfong.mybatis.many2many;

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

import com.bigfong.mybatis.many2many.domain.Student;
import com.bigfong.mybatis.many2many.domain.Teacher;
import com.bigfong.mybatis.many2many.mapper.StudentMapper;
import com.bigfong.mybatis.many2many.mapper.TeacherMapper;
import com.bigfong.mybatis.many2many.util.MybatisUtil;

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
        Teacher t1 = new Teacher();
        t1.setName("老师1");
        Teacher t2 = new Teacher();
        t2.setName("老师2");
        
        Student s1 = new Student();
        s1.setName("小七");
        Student s2 = new Student();
        s2.setName("花花");
        
        //维护对象之间关系
      /*  t1.getStudents().add(s1);
        t1.getStudents().add(s2);
        t2.getStudents().add(s1);
        t2.getStudents().add(s2);*/
        
        s1.getTeachers().add(t1);
        s1.getTeachers().add(t2);
        s2.getTeachers().add(t1);
        s2.getTeachers().add(t2);
       
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        teacherMapper.save(t1);
        teacherMapper.save(t2);
        studentMapper.save(s1);
        studentMapper.save(s2);
        
        //维护学生和老师关系的中间表的数据
        for(Teacher t:s1.getTeachers()) {
            studentMapper.insertRelationWithTeacher(s1.getId(), t.getId());
        }
        for(Teacher t:s2.getTeachers()) {
            studentMapper.insertRelationWithTeacher(s2.getId(), t.getId());
        }
        
        //提交事务
        session.commit();
        session.close();
    }
    
    @Test
    void testDelete() throws Exception { 
        Long studentId = 49L;
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        
        //先删除中间表
        studentMapper.deleteRelationWithTeacher(studentId);
        
        studentMapper.delete(studentId);
    }

    @Test
    void testGet() throws Exception { 
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.get(50L);
        System.out.println(student);
        System.out.println(student.getTeachers());//额外SQL
    }

   
}
