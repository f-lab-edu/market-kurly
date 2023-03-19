package com.hello.kurly.users.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, BigInteger> {

  Optional<Users> findByNickname(String nickname);

  Optional<Users> findByEmail(String email);

  boolean existsByNickname(String nickname);

  boolean existsByEmail(String email);
}
