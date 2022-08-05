package com.lee.service;

import com.lee.entity.User;
import com.lee.exception.MyException;
import com.lee.mapper.UserMapper;
import com.sun.xml.internal.ws.developer.StreamingAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOError;

/**
 * @author Lee(005013)
 * @date 2022/7/19 19:42
 */

public class TransactionService {

    @Autowired
    private Transaction2Service transaction2Service;

    @Autowired
    private UserMapper userMapper;


    public void method01() {

        transaction2Service.method02();
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

        System.out.println("method2执行完毕");
    }

    @Transactional(rollbackFor = Exception.class)
    public void method03() {
        User user = new User();
        user.setUserId("2");
        user.setUserName("method03");
        userMapper.insert(user);
        throw new IOError(new Throwable());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void method04() {
        User user = new User();
        user.setUserId("4");
        user.setUserName("method04");
        userMapper.insert(user);
        System.out.println("method04插入成功了");
        //method05();
    }

    @Transactional()
    public   void method05()  {
        User user = new User();
        user.setUserId("5");
        user.setUserName("method05");
        userMapper.insert(user);
        System.out.println("method05插入成功了");
        throw new MyException();
    }

}
