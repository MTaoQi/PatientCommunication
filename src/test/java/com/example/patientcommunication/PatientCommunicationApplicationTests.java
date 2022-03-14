package com.example.patientcommunication;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import pc.UserApplication;
import pc.disease.entity.User;
import pc.disease.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = UserApplication.class)
class PatientCommunicationApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("测试");
        user.setPassword("4567");
        user.setIdentity(1);
        user.setEmail("1234@qq.com");
        userMapper.insert(user);
    }

    @Test
    void test1() {
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("username","淘淘i");
        List<User> user = userMapper.selectByMap(stringStringHashMap);

        System.out.println(user);
    }
    @Test
    void test2() {
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("username","测试");
        User user = userMapper.selectOne(objectQueryWrapper);
        System.out.println(user);
    }


}
