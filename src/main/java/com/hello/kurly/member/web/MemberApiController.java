package com.hello.kurly.member.web;

import com.hello.kurly.member.web.dto.DuplicationCheckRequestDto;
import com.hello.kurly.member.web.dto.DuplicationCheckResponseDto;
import com.hello.kurly.member.web.dto.MemberJoinRequestDto;
import com.hello.kurly.member.web.dto.MemberResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

  @PostMapping("/api/v1/member/duplication-check")
  public DuplicationCheckResponseDto checkDuplicationByKey(@RequestBody DuplicationCheckRequestDto requestDto) {
    System.out.println("requestDto.getKey() = " + requestDto.getKey());
    if ("MEMBER_ID".equals(requestDto.getKey())) {
      //회원 아이디 중복 체크
    } else if ("EMAIL".equals(requestDto.getKey())) {
      //회원 이메일 중복 체크
    }
    return new DuplicationCheckResponseDto();
  }

  @PostMapping("/api/v1/member/join")
  public void join(@RequestBody MemberJoinRequestDto requestDto) {
  }

  @GetMapping("/api/v1/member")
  public MemberResponseDto member() {
    return new MemberResponseDto();
  }
}
