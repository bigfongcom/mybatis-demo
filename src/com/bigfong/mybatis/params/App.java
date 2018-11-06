package com.bigfong.mybatis.params;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigfong.mybatis.params.domain.Client;
import com.bigfong.mybatis.params.mapper.ClientMapper;
import com.bigfong.mybatis.params.util.MybatisUtil;

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
    void testLogin1() throws Exception {
        LoginVo vo = new LoginVo("bigfong", "123");
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login1(vo);
        session.close();
        System.out.println(client);
    }
    
    @Test
    void testLogin2() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                this.put("username", "lucy");
                this.put("password", "111");
            }
        };
        
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login2(map);
        session.close();
        System.out.println(client);
    }
    
    @Test
    void testLogin3() throws Exception {
       
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login3("lucy","111");
        session.close();
        System.out.println("testLogin3");
        System.out.println(client);
    }
}
