package com.kcj.user.service;

import com.kcj.primaryKeyGeneration.IdWorker;
import com.kcj.user.mapper.UserMapper;
import com.kcj.user.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserService {

    final static String[] titleArr = {"用户名","密码","手机号","创建时间","性别"};

    final static Map<String,Integer> excelColMap = new HashMap() {{
        put("username",0);put("password",1);put("phone",2);put("created",3);put("note",4);
    }};

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private IdWorker idWorker;


    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional//jdbc引入已经完成事务了，这里加只是告诉spring当前方法需要事务控制
    public void insertUser(User user){
        userMapper.insert(user);
    }
}
