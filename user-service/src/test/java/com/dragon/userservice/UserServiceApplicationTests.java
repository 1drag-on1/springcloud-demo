package com.dragon.userservice;

import com.dragon.userservice.pojo.User;
import com.dragon.userservice.service.UserService;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Scanner;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired(required = false)
    private UserService userService;

    @Test
    void contextLoads() {
//        List<User> users = userService.findAll();
//        User user = userService.findUserById("628b7c938e1f576b452644d7");
        User user = new User();
        user.setName("ll");
        user.setUserid(3);
        userService.saveUser(user);
    }

    @Test
    public void test(){
        Page<User> users = userService.findUserListByUserid(3, 1, 2);
        System.out.println(users.getTotalElements());
        System.out.println(users.getContent());
    }

    @Test
    public void test01(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void test02(){
        UpdateResult updateResult = userService.updateUserUserid("628c8952ded49632c0ebca12");
        System.out.println(updateResult);
    }

    @Test
    public void exam(){
        System.out.println("//=======================//");
        System.out.println("//=======================//");
        System.out.println("//         >_<           //");
        System.out.println("//    |------------|     //");
        System.out.println("//    | 考试加油！！ |     //");
        System.out.println("//    |------------|     //");
        System.out.println("//                       //");
        System.out.println("//=======================//");
        System.out.println("//=======================//");
        System.out.println("请烧香");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.equals("烧香")){
            System.out.println("烧香成功!");
        }
    }

}
