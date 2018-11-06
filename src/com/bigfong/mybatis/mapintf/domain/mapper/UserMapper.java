package com.bigfong.mybatis.mapintf.domain.mapper;

import java.util.List;

import com.bigfong.mybatis.mapintf.domain.User;

/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年11月3日 下午10:15:40
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public interface UserMapper {
    void save(User u);

    void update(User u);

    void delete(Long id);

    User get(Long id);

    List<User> listAll();
}
