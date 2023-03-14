package com.hello.kurly.v1.user.controller;

import com.hello.kurly.v1.user.dto.AddressDto;
import com.hello.kurly.v1.user.dto.ExistTarget;
import com.hello.kurly.v1.user.dto.SignUpRequestDto;
import com.hello.kurly.v1.user.dto.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @PostMapping
  public UserResponseDto create(@RequestBody SignUpRequestDto dto) {
    ArrayList<AddressDto> addresses = new ArrayList<>();
    addresses.add(new AddressDto(true, "", "", "", ""));
    return new UserResponseDto("", "", "", addresses);
  }

  @GetMapping("/{id}")
  public UserResponseDto getUser(@PathVariable Long id) {
    return null;
  }

  @PutMapping("/{id}/profile")
  public Long updateProfile(@PathVariable Long id) {
    return null;
  }

  @GetMapping("/me")
  public UserResponseDto getMe(@PathVariable Long id) {
    return null;
  }

  @GetMapping("/existence")
  public boolean isExistTarget(@RequestParam("target") ExistTarget target,
                               @RequestParam("value") String value) {
    return false;
  }
}
