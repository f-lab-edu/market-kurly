package com.hello.kurly.member.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DuplicationCheckResponseDto {

  private boolean isDuplicated;

  public DuplicationCheckResponseDto(boolean isDuplicated) {
    this.isDuplicated = isDuplicated;
  }
}
