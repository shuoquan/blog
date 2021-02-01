package com.shuoquan.blog.dao;
import com.shuoquan.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
  User findUserByUsernameAndPassword(String username, String password);
}
