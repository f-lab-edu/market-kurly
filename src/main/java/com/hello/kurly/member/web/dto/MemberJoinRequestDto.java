package com.hello.kurly.member.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberJoinRequestDto {

  private String memberId;
  private String password;
  private String name;
  private String email;
  private String mobileNumber;
  private String numberAddress;
  private String baseAddressType;
  private String roadAddress;
  private String subAddress;
  private String zipCode;
  private String zoneCode;
  private String joinInflowType;
  private String gender;

  public MemberJoinRequestDto(String memberId, String password, String name, String email, String mobileNumber, String numberAddress, String baseAddressType, String roadAddress, String subAddress, String zipCode, String zoneCode, String joinInflowType, String gender) {
    this.memberId = memberId;
    this.password = password;
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.numberAddress = numberAddress;
    this.baseAddressType = baseAddressType;
    this.roadAddress = roadAddress;
    this.subAddress = subAddress;
    this.zipCode = zipCode;
    this.zoneCode = zoneCode;
    this.joinInflowType = joinInflowType;
    this.gender = gender;
  }
}
