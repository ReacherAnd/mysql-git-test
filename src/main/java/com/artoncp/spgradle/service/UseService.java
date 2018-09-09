package com.artoncp.spgradle.service;

import com.artoncp.spgradle.dao.UserDao;
import com.artoncp.spgradle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseService {
    @Autowired
    private UserDao userDao;

    public List<User> getAll(){
        List<User> list=userDao.findAll();
        return list;
    }
}
