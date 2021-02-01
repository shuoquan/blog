package com.shuoquan.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shuoquan.blog.dao.UserDao;
import com.shuoquan.blog.entity.User;
import com.shuoquan.blog.service.UserService;
import com.shuoquan.blog.utils.JwtUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;
  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  public Object checkUser(String username, String password) {
    User user =  userDao.findUserByUsernameAndPassword(username, password);
    if(user==null) return JSON.toJSON(user);
    JSONObject userObject = (JSONObject) JSON.toJSON(user);
    String token = JwtUtil.sign(String.valueOf(user.getId()));
    userObject.put("token", token);
    return userObject;
  }
}
