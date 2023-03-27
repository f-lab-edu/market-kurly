package com.hello.kurly.users.v1.service;

import com.hello.kurly.common.exception.UserNotFoundException;
import com.hello.kurly.users.domain.Users;
import com.hello.kurly.users.domain.UsersRepository;
import com.hello.kurly.users.v1.dto.UsersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@RequiredArgsConstructor
@Service
@Transactional
public class UsersService {

  private final UsersRepository usersRepository;

  public UsersResponseDto getUser(BigInteger id) {
    Users findUser = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    return UsersResponseDto.from(findUser);
  }
}
