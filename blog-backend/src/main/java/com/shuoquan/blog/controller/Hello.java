package com.shuoquan.blog.controller;

import com.shuoquan.blog.entity.User;
import com.shuoquan.blog.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
  @Autowired
  private UserService userService;
  @GetMapping("/hello")
  public List<User> Hello(@RequestParam(value = "name", required = false) String name) {
    return userService.findAll();
  }
}
