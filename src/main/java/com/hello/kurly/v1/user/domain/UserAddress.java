package com.hello.kurly.v1.user.domain;

import com.hello.kurly.common.model.Address;
import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_address")
@Entity
public class UserAddress extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id; //pk

  private boolean is_base_delivery_address; //기본배송지여부

  private String delivery_policy; //배송정책(새벽배송, 낮배송, 배송불가)

  @Embedded
  private Address homeAddress;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}
