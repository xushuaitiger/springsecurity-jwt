package com.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    // 路由映射到/users
    @RequestMapping(value = "/users", produces="application/json;charset=UTF-8")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String usersList() {

        ArrayList<String> users =  new ArrayList<String>(){{
            add("freewolf");
            add("tom");
            add("jerry");
        }};

        return JSONResult.fillResultString(0, "", users);
    }

    @RequestMapping(value = "/hello", produces="application/json;charset=UTF-8")
    public String hello() {
        ArrayList<String> users =  new ArrayList<String>(){{ add("hello"); }};
        return JSONResult.fillResultString(0, "", users);
    }

    @RequestMapping(value = "/world", produces="application/json;charset=UTF-8")
    public String world() {
        ArrayList<String> users =  new ArrayList<String>(){{ add("world"); }};
        return JSONResult.fillResultString(0, "", users);
    }
}
