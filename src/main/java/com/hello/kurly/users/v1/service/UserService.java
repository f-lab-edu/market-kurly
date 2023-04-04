package com.hello.kurly.users.v1.service;

import com.hello.kurly.common.exception.EmailAlreadyExistsException;
import com.hello.kurly.common.exception.NicknameAlreadyExistsException;
import com.hello.kurly.common.exception.UserNotFoundException;
import com.hello.kurly.users.domain.User;
import com.hello.kurly.users.domain.UserRepository;
import com.hello.kurly.users.v1.dto.SignUpRequest;
import com.hello.kurly.users.v1.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserResponse signUp(SignUpRequest request) {
    validateSignUp(request);
    User user = request.toEntity();
    user.encodePassword(passwordEncoder);
    user.addAuthority();
    user.addBasicGrade();
    return UserResponse.from(userRepository.save(user));
  }

  public UserResponse getUser(BigInteger id) {
    User findUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    return UserResponse.from(findUser);
  }

  private void validateSignUp(SignUpRequest request) {
    if (userRepository.existsByNickname(request.getNickname())) {
      throw new NicknameAlreadyExistsException();
    }
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new EmailAlreadyExistsException();
    }
  }
}
