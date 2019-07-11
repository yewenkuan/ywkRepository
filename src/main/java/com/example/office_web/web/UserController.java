package com.example.office_web.web;


import com.example.office_web.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ywk
 * @since 2019-05-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/test")
    public void test(){
        userService.selectUser();
    }

    @RequestMapping("/test1")
    public void test1(){
        userService.getPage();
    }
}
