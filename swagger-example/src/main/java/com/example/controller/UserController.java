package com.example.controller;

import com.example.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户相关的请求")
@RestController
@RequestMapping("user")
public class UserController {

    @ApiOperation("获取用户信息")
    @GetMapping
    public String getUser(User user) {
        return "张三";
    }

    @PostMapping
    @ApiImplicitParam(name = "username", value = "用户名",
        dataType = "string" , paramType = "请求类型",defaultValue = "默认值", example = "eric-wei"
    )
    public String addUser(String username) {
        return username;
    }

    @DeleteMapping
    public User delUser() {
        User user = new User("Eric-Wei", 21);
        return user;
    }

    @PutMapping()
    public String putUser(@RequestBody User user){
        return "user";
    }
}
