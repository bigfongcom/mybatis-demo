package com.bigfong.mybatis.dynamicsql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bigfong.mybatis.dynamicsql.domain.Employee;


/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年11月3日 下午10:15:40
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public interface EmployeeMapper {
    /*
    <insert id="save" useGeneratedKeys="true" keyProperty="id" >
                insert into  t_user (name,salary) values (#{name},#{salary})
        </insert>
     */
    @Insert("insert into  t_user (name,salary) values (#{name},#{salary})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    void save(Employee u);

    /*
     <update id="update" >
            update t_user set name = #{name},salary = #{salary} where id = #{id}
    </update>
     */
    @Update("update t_user set name = #{name},salary = #{salary} where id = #{id}")
    void update(Employee u);

    /*
     <delete id="delete">
                delete from t_user where id = #{id}
        </delete>
     */
    @Delete("delete from t_user where id = #{id}")
    void delete(Long id);

    /*
     <select id="get"  resultType="User">
            select id,name,salary from t_user where id = #{id}
    </select> 
     */
    @Select("select id as u_id,name as u_name,salary as u_salary from t_user where id = #{id}")
    @Results(id="BaseResultMap",value= {
            @Result(column="u_id",property="id"),
            @Result(column="u_name",property="name"),
            @Result(column="u_salary",property="salary"),
    })
    Employee get(Long id);

    /*
     <select id="listAll" resultType="User">
                select id,name,salary from t_user
        </select>
     */
    @Select("select id,name,salary from t_user")
    @ResultType(Employee.class)
    List<Employee> listAll();
}
