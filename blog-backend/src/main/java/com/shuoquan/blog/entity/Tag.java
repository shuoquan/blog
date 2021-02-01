package com.shuoquan.blog.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  @ManyToMany(mappedBy = "tags")
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
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }

}
