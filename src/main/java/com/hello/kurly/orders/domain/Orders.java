package com.hello.kurly.orders.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import com.hello.kurly.users.domain.Users;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
@Entity
public class Orders extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private BigInteger id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "users_id")
  private Users users;

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "delivery_id", referencedColumnName = "id")
  private Delivery delivery;

  @OneToMany(mappedBy = "orders")
  private List<OrderProduct> orderProducts = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private OrderType status; //주문상태(주문완료, 주문취소, 주문불가)

  public Orders(BigInteger id,
                Users users,
                Delivery delivery,
                OrderType status) {
    this.id = id;
    this.users = users;
    this.delivery = delivery;
    this.status = status;
  }
}
