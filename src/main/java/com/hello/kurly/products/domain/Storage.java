package com.hello.kurly.products.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Table(name = "storages")
@Entity
public class Storage extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; // 상위 상품 pk

  @OneToOne(fetch = LAZY, mappedBy = "storage")
  private Product product;

  public Storage(Long id, Product product) {
    this.id = id;
    this.product = product;
  }

  public Storage(Long id) {
    this.id = id;
  }
}
