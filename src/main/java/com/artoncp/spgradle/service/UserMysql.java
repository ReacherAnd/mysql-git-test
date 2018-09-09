package com.artoncp.spgradle.service;


import com.artoncp.spgradle.dao.UserDao;
import com.artoncp.spgradle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMysql {

    @Autowired
    private UserDao userDao;

    public boolean insertById(User user){
        int rs=userDao.insertUser(user);
        if (rs>0)
            return true;
        return false;
    }

    public boolean findById(String id){
        User user=userDao.fingById(id);
        if(user!=null)
            return true;
        return false;

    }
}
