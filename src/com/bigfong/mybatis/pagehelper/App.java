package com.bigfong.mybatis.pagehelper;

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

import com.bigfong.mybatis.pagehelper.domain.Employee;
import com.bigfong.mybatis.pagehelper.mapper.EmployeeMapper;
import com.bigfong.mybatis.pagehelper.query.EmployeeQueryObject;
import com.bigfong.mybatis.pagehelper.service.IEmployeeService;
import com.bigfong.mybatis.pagehelper.service.impl.EmployeeServiceImpl;
import com.bigfong.mybatis.pagehelper.util.MybatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
    void testPageHelper() throws Exception{
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        //设置分页
        PageHelper.startPage(1,2);
        List<Employee> list = employeeMapper.listAll();
        System.out.println(list);
        for(Employee em:list) {
            System.out.println(em);
        }
        
        PageInfo pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
    }

    @Test
    void testQuery()throws Exception{
        EmployeeQueryObject qo = new EmployeeQueryObject();       
        IEmployeeService service = new EmployeeServiceImpl();
        qo.setKeyword("2");
        //qo.setMinSalary(new BigDecimal("1000"));
        //qo.setMaxSalary(new BigDecimal("2000"));
        //qo.setDeptId(30L);
        PageInfo pageInfo = service.query(qo);
        System.out.println(pageInfo.getTotal());
        for (Object o : pageInfo.getList()) {
                System.out.println(o);
        }
    }
    
}
