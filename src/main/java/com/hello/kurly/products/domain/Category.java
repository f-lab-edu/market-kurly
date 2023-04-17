package com.hello.kurly.products.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Table(name = "categories")
@Entity
public class Category extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name; // 카테고리 명

  @OneToMany(mappedBy = "category", cascade = ALL, orphanRemoval = true)
  private List<SubProduct> subProducts = new ArrayList<>();

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
