package com.hello.kurly.users.v1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public class SignUpRequestDto {

  private String nickname;
  private String name;
  private String email;
  private String mobileNumber;
  private String birthday;
  private String gender;
  private String password;
  private String zipCode;
  private String address;
  private String addressDetail;

  public SignUpRequestDto(String nickname, String name, String email, String mobileNumber, String birthday, String gender, String password, String zipCode, String address, String addressDetail) {
    this.nickname = nickname;
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.birthday = birthday;
    this.gender = gender;
    this.password = password;
    this.zipCode = zipCode;
    this.address = address;
    this.addressDetail = addressDetail;
  }
}
