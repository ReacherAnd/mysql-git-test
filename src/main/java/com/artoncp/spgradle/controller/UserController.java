package com.artoncp.spgradle.controller;

import com.artoncp.spgradle.entity.User;
import com.artoncp.spgradle.service.UseService;
import com.artoncp.spgradle.service.UserMysql;
import com.artoncp.spgradle.service.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRedis userRedis;
    @Autowired
    private UserMysql userMysql;

    @Autowired
    private UseService useService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        List<User> list=useService.getAll();
        return list;
    }

    @GetMapping("/redisAndMysql")
    public String get(String key){
        System.out.println(key+"====key");
        String redisRs=userRedis.get(key);
        if(StringUtils.isEmpty(redisRs)){
            System.out.println(key+"====key 1.0");
            //redis no data isexist? mysql
            boolean mysqlRs=userMysql.findById(key);
            if(mysqlRs){
                return "okay+mysql";
            }else{
                return "error+mysql";
            }

        }
        return "redis has data ";

    }
}
