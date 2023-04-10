package com.becom.service;

import com.becom.common.DataSourceContextHolder;
import com.becom.demos.web.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void insertUser(){
        DataSourceContextHolder.setDataSource("ds1");
        String sql = "insert into sys_config(variable,value) values('111222','22222')";
        jdbcTemplate.update(sql);
        DataSourceContextHolder.setDataSource("ds2");
        String sql2 = "insert into student(id,name,age) values('2202','test202',222)";
        jdbcTemplate.update(sql2);
    }
    public void insertIntoDB1(User user){


    }
    public void insertIntoDB2(User user){


    }
}
