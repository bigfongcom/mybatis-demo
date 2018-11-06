package com.bigfong.mybatis.advancequery;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bigfong.mybatis.advancequery.domain.Employee;
import com.bigfong.mybatis.advancequery.mapper.EmployeeMapper;
import com.bigfong.mybatis.advancequery.query.EmployeeQueryObject;
import com.bigfong.mybatis.advancequery.query.PageResult;
import com.bigfong.mybatis.advancequery.service.IEmployeeService;
import com.bigfong.mybatis.advancequery.service.impl.EmployeeServiceImpl;
import com.bigfong.mybatis.advancequery.util.MybatisUtil;

public class App {

    @Test
    void testPageHelper() throws Exception {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
    }

    @Test
    void testQuery() throws Exception {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        IEmployeeService service = new EmployeeServiceImpl();
        qo.setKeyword("2");
        // qo.setMinSalary(new BigDecimal("1000"));
        // qo.setMaxSalary(new BigDecimal("2000"));
        // qo.setDeptId(30L);
        PageResult pageResult = service.query(qo);
        System.out.println(pageResult.getTotalCount());
        for (Object o : pageResult.getResult()) {
            System.out.println(o);
        }
    }

    // 需求:按照员工的关键字(abc),工资范围,所属部门来查询

    // 高级查询
    @Test
    void test1() throws Exception {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        // qo.setKeyword(" ");
        qo.setMinSalary(new BigDecimal("1000"));
        qo.setMaxSalary(new BigDecimal("2000"));
        qo.setDeptId(30L);
        // ----------------------------------------
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        List<Employee> es = employeeMapper.queryForList(qo);
        for (Employee e : es) {
            System.out.println(e);
        }
    }

    @Test
    void test2() throws Exception {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setMinSalary(new BigDecimal("1000"));
        qo.setMaxSalary(new BigDecimal("2000"));
        qo.setDeptId(30L);
        // ----------------------------------------
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        int rows = employeeMapper.queryForCount(qo);
        System.out.println(rows);
    }
}
