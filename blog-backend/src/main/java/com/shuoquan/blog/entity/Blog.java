package com.shuoquan.blog.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "blog")
public class Blog {

  @Id
  @GeneratedValue
  private long id;
  private String title;
  private String content;
  private String firstPic;
  private long originality;
  private long views;
  private long appreciation;
  private long share;
  private long commentable;
  private long recommended;
  private long createTime;
  private long updateTime;
  @ManyToOne
  private Type type;
  @ManyToMany(cascade = {CascadeType.PERSIST})
  private List<Tag> tags = new ArrayList<>();
  @ManyToOne
  private User user;
  @OneToMany(mappedBy = "blog")
  private List<Comment> comments = new ArrayList<>();

//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//
//  public String getTitle() {
//    return title;
//  }
//
//  public void setTitle(String title) {
//    this.title = title;
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
//  public String getFirstPic() {
//    return firstPic;
//  }
//
//  public void setFirstPic(String firstPic) {
//    this.firstPic = firstPic;
//  }
//
//
//  public long getOriginality() {
//    return originality;
//  }
//
//  public void setOriginality(long originality) {
//    this.originality = originality;
//  }
//
//
//  public long getViews() {
//    return views;
//  }
//
//  public void setViews(long views) {
//    this.views = views;
//  }
//
//
//  public long getAppreciation() {
//    return appreciation;
//  }
//
//  public void setAppreciation(long appreciation) {
//    this.appreciation = appreciation;
//  }
//
//
//  public long getShare() {
//    return share;
//  }
//
//  public void setShare(long share) {
//    this.share = share;
//  }
//
//
//  public long getCommentable() {
//    return commentable;
//  }
//
//  public void setCommentable(long commentable) {
//    this.commentable = commentable;
//  }
//
//
//  public long getRecommended() {
//    return recommended;
//  }
//
//  public void setRecommended(long recommended) {
//    this.recommended = recommended;
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
