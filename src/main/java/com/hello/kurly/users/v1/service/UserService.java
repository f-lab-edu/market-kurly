package com.hello.kurly.users.v1.service;

import com.hello.kurly.common.exception.UserNotFoundException;
import com.hello.kurly.users.domain.User;
import com.hello.kurly.users.domain.UserRepository;
import com.hello.kurly.users.v1.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;

  public UserResponseDto getUser(BigInteger id) {
    User findUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    return UserResponseDto.from(findUser);
  }
}
