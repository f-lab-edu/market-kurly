package com.hello.kurly.users.v1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public class UsersResponseDto {

  private String nickname;
  private String grade;
  private String name;
  private List<AddressDto> addresses = new ArrayList<>();

  public UsersResponseDto(String nickname, String grade, String name, List<AddressDto> addresses) {
    this.nickname = nickname;
    this.grade = grade;
    this.name = name;
    this.addresses = addresses;
  }
}