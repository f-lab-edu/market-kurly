package com.hello.kurly.member.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

  private Long memberNo;
  private String memberId;
  private String mobileNo;
  private String name;
  private String email;
}
