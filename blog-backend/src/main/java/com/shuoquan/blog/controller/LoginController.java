package com.shuoquan.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.shuoquan.blog.annotation.JwtToken;
import com.shuoquan.blog.entity.User;
import com.shuoquan.blog.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {
  @Autowired
  private UserService userService;
  @PostMapping("/login")
  public Object Login(@RequestParam(required = false) String username, @RequestParam(required = false) String password) {
    return userService.checkUser(username, password);
  }

  @JwtToken
  @GetMapping("/hello")
  public String sayHello() {
    return "hello world";
  }
}
