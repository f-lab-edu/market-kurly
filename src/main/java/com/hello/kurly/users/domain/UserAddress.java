package com.hello.kurly.users.domain;

import com.hello.kurly.common.model.Address;
import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users_addresses")
@Entity
public class UserAddress extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private BigInteger id; //pk

  private boolean isBaseDeliveryAddress; //기본배송지여부

  private String deliveryPolicy; //배송정책(새벽배송, 낮배송, 배송불가)

  @Embedded
  private Address homeAddress;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}
