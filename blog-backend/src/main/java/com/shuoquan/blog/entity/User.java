package com.shuoquan.blog.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  private long id;
  private String nickname;
  private String username;
  private String password;
  private String email;
  private String avatar;
  private long type;
  private String createTime;
  private String updateTime;
  @OneToMany(mappedBy = "user")
  private List<Blog> blogs = new ArrayList<>();

//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//
//  public String getNickname() {
//    return nickname;
//  }
//
//  public void setNickname(String nickname) {
//    this.nickname = nickname;
//  }
//
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//
//  public String getAvatar() {
//    return avatar;
//  }
//
//  public void setAvatar(String avatar) {
//    this.avatar = avatar;
//  }
//
//
//  public long getType() {
//    return type;
//  }
//
//  public void setType(long type) {
//    this.type = type;
//  }
//
//
//  public long getCreateTime() {
//    return createTime;
//  }
//
//  public void setCreateTime(long createTime) {
//    this.createTime = createTime;
//  }
//
//
//  public long getUpdateTime() {
//    return updateTime;
//  }
//
//  public void setUpdateTime(long updateTime) {
//    this.updateTime = updateTime;
//  }

}
