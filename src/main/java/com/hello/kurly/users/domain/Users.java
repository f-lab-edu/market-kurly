package com.hello.kurly.users.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
@Entity
public class Users extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private BigInteger id; //pk

  @Column(nullable = false, length = 20, unique = true)
  private String nickname; //회원아이디

  private String status; //회원상태(일반, 탈퇴, 휴먼, ...)

  @Enumerated(EnumType.STRING)
  private RoleType role; //권한(관리자, 사용자)

  private String grade; //등급(일반, 프렌즈, ...)

  @Column(nullable = false, length = 20)
  private String name; //회원명

  @Column(nullable = false, length = 30, unique = true)
  private String email; //이메일

  @Column(nullable = false)
  private String mobileNumber; //휴대폰번호

  private LocalDate birthday; //생일

  private String gender; //성별(NONE, MALE, FEMALE)

  private String password; //비밀번호

  @OneToMany(mappedBy = "users", cascade = ALL, orphanRemoval = true)
  private List<UsersAddresses> usersAddresses = new ArrayList<>();

  public Users(String nickname,
               String status,
               RoleType role,
               String grade,
               String name,
               String email,
               String mobileNumber,
               LocalDate birthday,
               String gender,
               String password,
               List<UsersAddresses> usersAddresses) {
    this.nickname = nickname;
    this.status = status;
    this.role = role;
    this.grade = grade;
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.birthday = birthday;
    this.gender = gender;
    this.password = password;
    this.usersAddresses = usersAddresses;
  }
}
