package com.artopcn.mysqltest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther: gumuming
 * @Date: 2018/9/9 08:27
 */
@Table(name = "user")
@Entity
public class User {
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
}
