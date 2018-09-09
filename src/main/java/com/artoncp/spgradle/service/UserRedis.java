package com.artoncp.spgradle.service;


import java.util.List;
import java.util.concurrent.TimeUnit;


import com.artoncp.spgradle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/** 
* @ClassName: UserRedis 
* @Description:  redis 提供5种数据类型的操作
* String ,hash ,list , set , zset
* @author mengfanzhu
* @date 2017年2月21日 下午2:01:43 
*/

 @Component
public class UserRedis {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
   /* @Autowired
    private RedisConfiguration redisConfiguration;
    RedisTemplate rt=redisConfiguration.redisTemplate(new RedisConnectionFactory() {
    });*/
    public String get(String key) {
        System.out.println(key+"service");
        if (StringUtils.isEmpty(key)) {
            System.out.println(key+"service1.0");
            return null;
        }
        System.out.println(key+"service2.0");
        return redisTemplate.opsForValue().get(key);
    }

    //设置setKeyValue
    public void save(String key,String value){
        System.out.println("key"+key+"value"+value);
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return;
        }
        redisTemplate.opsForValue().set(key,value);
    }
    //取得List 内的数据
    public List<String> getListByKey(String key){
        Gson gson = new Gson();
        List<String> userList = null;
        String userJson = redisTemplate.opsForValue().get(key);
        System.out.println(userJson+"======userJson");
        if(!StringUtils.isEmpty(userJson)){
            userList =  gson.fromJson(userJson, new TypeToken<List<User>>(){}.getType());
        }
        return userList;
    }

    //delete redis data by key
    public boolean deleteKey(String key ){
        boolean b=redisTemplate.opsForValue().getOperations().delete(key);
        return b;
    }

    //add list data
    public void setList(String key,List<String> list){
        for (String  string:list
             ) {
         //   redisTemplate.opsForValue().set(key,string);
            //存放list data type
           // redisTemplate.opsForList().leftPush(key,string);
            //存放 zset data type
           // redisTemplate.opsForSet().add(key,string);


        }
        redisTemplate.opsForHash().put("hashkey","age","26");
        redisTemplate.opsForHash().put("hashkey","sex","1");
    }



}