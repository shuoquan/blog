package com.shuoquan.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.shuoquan.blog.entity.User;
import java.util.List;

public interface UserService {
  List<User> findAll();
  Object checkUser(String username, String password);
}
