package com.hello.kurly.products.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Table(name = "sellers")
@Entity
public class Seller extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; // 상위 상품 pk

  @OneToMany(fetch = LAZY, mappedBy = "seller")
  private List<Product> products;

  public Seller(Long id) {
    this.id = id;
  }
}
