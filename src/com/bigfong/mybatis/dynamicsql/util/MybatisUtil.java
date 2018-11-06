package com.bigfong.mybatis.dynamicsql.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月3日 下午6:10:50
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class MybatisUtil {
    private static SqlSessionFactory factory = null;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config-dynamicsql.xml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //返回一个SqlSession对象
    public static SqlSession getSession() {
        return factory.openSession();
    }
}
