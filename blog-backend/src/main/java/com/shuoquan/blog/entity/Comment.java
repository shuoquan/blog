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
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue
  private long id;
  private String nickname;
  private String email;
  private String content;
  private String avatar;
  private long createTime;
  @ManyToOne
  private Blog blog;
  @OneToMany(mappedBy = "parentComment")
  private List<Comment> replyComments = new ArrayList<>();
  @ManyToOne
  private Comment parentComment;

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
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//
//  public String getContent() {
//    return content;
//  }
//
//  public void setContent(String content) {
//    this.content = content;
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
//  public long getCreateTime() {
//    return createTime;
//  }
//
//  public void setCreateTime(long createTime) {
//    this.createTime = createTime;
//  }

}
