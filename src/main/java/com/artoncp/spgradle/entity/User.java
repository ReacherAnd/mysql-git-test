package com.artoncp.spgradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
public class User {
    private  String userId;
    private  String name;
    private  String password;
}
