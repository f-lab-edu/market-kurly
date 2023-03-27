package com.hello.kurly.users.v1.controller;

import com.hello.kurly.users.v1.dto.AddressDto;
import com.hello.kurly.users.v1.dto.ExistTarget;
import com.hello.kurly.users.v1.dto.SignUpRequestDto;
import com.hello.kurly.users.v1.dto.UsersResponseDto;
import com.hello.kurly.users.v1.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UsersController {

  private final UsersService usersService;

  @PostMapping
  public UsersResponseDto create(@RequestBody SignUpRequestDto dto) {

    ArrayList<AddressDto> addresses = new ArrayList<>();
    addresses.add(new AddressDto(true, "", "", "", ""));
    return new UsersResponseDto("", "", "", addresses);
  }

  @GetMapping("/{id}")
  public UsersResponseDto getUser(@PathVariable BigInteger id) {

    return usersService.getUser(id);
  }

  @PutMapping("/{id}/profile")
  public Long updateProfile(@PathVariable BigInteger id) {
    return null;
  }

  @GetMapping("/me")
  public UsersResponseDto getMe(@PathVariable BigInteger id) {
    return null;
  }

  @GetMapping("/existence")
  public boolean isExistTarget(@RequestParam("target") ExistTarget target,
                               @RequestParam("value") String value) {
    return false;
  }
}
