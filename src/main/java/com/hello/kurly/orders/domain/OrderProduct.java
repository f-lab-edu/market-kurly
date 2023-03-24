package com.hello.kurly.orders.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import com.hello.kurly.products.domain.Products;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "order_product")
@Entity
public class OrderProduct extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private BigInteger id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "orders_id")
  private Orders orders;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "products_id")
  private Products products;

  private Integer quantity; // 수량

  private BigInteger productPrice; // 가격

  public OrderProduct(BigInteger id,
                      Orders orders,
                      Products products,
                      Integer quantity,
                      BigInteger productPrice) {
    this.id = id;
    this.orders = orders;
    this.products = products;
    this.quantity = quantity;
    this.productPrice = productPrice;
  }
}
