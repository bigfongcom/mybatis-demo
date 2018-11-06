package com.bigfong.mybatis.many2many.mapper;

import org.apache.ibatis.annotations.Param;

import com.bigfong.mybatis.many2many.domain.Student;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月5日 上午11:53:42
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface StudentMapper {
    void save(Student s);
    
    void insertRelationWithTeacher(@Param("studentId")Long studentId,@Param("teacherId")Long teacherId);

    void delete(Long id);

    void deleteRelationWithTeacher(Long studentId);

    Student get(Long studentId);
}
