package com.hello.kurly.users.v1.dto;

import com.hello.kurly.users.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public class UserResponseDto {

  private String nickname;
  private String grade;
  private String name;
  private List<AddressDto> addresses = new ArrayList<>();

  public UserResponseDto(String nickname, String grade, String name, List<AddressDto> addresses) {
    this.nickname = nickname;
    this.grade = grade;
    this.name = name;
    this.addresses = addresses;
  }

  private UserResponseDto(User user) {
    this.nickname = user.getNickname();
    this.grade = user.getGrade();
    this.name = user.getName();
    this.addresses = new ArrayList<>();
  }

  public static UserResponseDto from(User user) {
    return new UserResponseDto(user);
  }
}