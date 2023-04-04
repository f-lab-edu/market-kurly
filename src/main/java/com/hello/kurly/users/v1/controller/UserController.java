package com.hello.kurly.users.v1.controller;

import com.hello.kurly.users.v1.dto.ExistTarget;
import com.hello.kurly.users.v1.dto.SignUpRequest;
import com.hello.kurly.users.v1.dto.UserResponse;
import com.hello.kurly.users.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  @PostMapping("/signup")
  public UserResponse signUp(@RequestBody SignUpRequest request) {

    return userService.signUp(request);
  }

  @GetMapping("/{id}")
  public UserResponse getUser(@PathVariable Long id) {

    return userService.getUser(id);
  }

  @PutMapping("/{id}/profile")
  public Long updateProfile(@PathVariable Long id) {
    return null;
  }

  @GetMapping("/me")
  public UserResponse getMe(@PathVariable Long id) {
    return null;
  }

  @GetMapping("/existence")
  public boolean isExistTarget(@RequestParam("target") ExistTarget target,
                               @RequestParam("value") String value) {
    return false;
  }
}
