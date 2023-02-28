package com.hello.kurly.member.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DuplicationCheckRequestDto {

  private String key;
  private String value;

  public DuplicationCheckRequestDto(String key, String value) {
    this.key = key;
    this.value = value;
  }
}
