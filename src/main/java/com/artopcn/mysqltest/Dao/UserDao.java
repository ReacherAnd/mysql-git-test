package com.artopcn.mysqltest.Dao;

import com.artopcn.mysqltest.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Auther: gumuming
 * @Date: 2018/9/9 08:30
 */
@Mapper
@Component
public interface UserDao {
    @Select("select name,age from user where name=#{name}")
    User findByName(String name);

}
