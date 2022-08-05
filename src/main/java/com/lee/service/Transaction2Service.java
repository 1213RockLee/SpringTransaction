package com.lee.service;

import com.lee.entity.User;
import com.lee.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lee(005013)
 * @date 2022/7/21 11:00
 */
@Service
public class Transaction2Service {


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    private UserMapper userMapper;


    public void method01() {
        System.out.println(1 / 0);
        method02();
        User user = new User();
        user.setUserId("1");
        user.setUserName("method01");
        userMapper.insert(user);
        System.out.println("method1执行完毕");

    }

    @Transactional(rollbackFor = Throwable.class)
    public void method02() {
        User user = new User();
        user.setUserId("2");
        user.setUserName("method02");
        userMapper.insert(user);
        System.out.println(1/0);
        System.out.println("method2执行完毕");
    }
}
