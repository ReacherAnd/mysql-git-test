package com.artoncp.spgradle.dao;

import com.artoncp.spgradle.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao extends JpaRepository<User, Long> {
    @Select("select userId,name,password from user")
    public List<User> findAll();
    @Select("select userId,name,password from user where userId =${userId}")
    public User fingById(@Param("userId") String userId);

    @Insert("insert into user values(userId,name,password)")
    public int insertUser(User user);
    @Update("update user set name=${name},password=${password} where userId=${userId} ")
    public int updateUserById(User user);

}
