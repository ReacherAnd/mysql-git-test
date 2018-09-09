package com.artopcn.mysqltest.controller;

import com.artopcn.mysqltest.Dao.UserDao;
import com.artopcn.mysqltest.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: gumuming
 * @Date: 2018/9/9 08:32
 */
//@org.springframework.stereotype.Controller
@RestController
public class Controller {

    @Resource
    private UserDao userDao;
    @GetMapping("/getName")
    public String getName(String name){
        return userDao.findByName(name).toString()+"==1.0";
    }

    @RequestMapping("/findByName")
    public User get(String name){
        return userDao.findByName(name);
    }
}
