package com.hello.kurly.users.domain;

import com.hello.kurly.common.exception.UsersNotFoundException;
import com.hello.kurly.config.AuditConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import static com.hello.kurly.factory.UsersFactory.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Import(AuditConfig.class)
@DataJpaTest
class UsersRepositoryTest {

  @Autowired
  UsersRepository userRepository;

  @PersistenceContext
  EntityManager em;

  @Test
  @DisplayName("회원아이디로 회원을 조회한다")
  void findByNickname() {

    //given
    Users user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when
    Users findUser = userRepository.findByNickname(user.getNickname()).orElseThrow(UsersNotFoundException::new);

    //then
    assertThat(findUser.getNickname()).isEqualTo(user.getNickname());
  }

  @Test
  @DisplayName("이메일로 회원을 조회한다")
  void findByEmail() {

    //given
    Users user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when
    Users findUser = userRepository.findByEmail(user.getEmail()).orElseThrow(UsersNotFoundException::new);

    //then
    assertThat(findUser.getEmail()).isEqualTo(user.getEmail());
  }

  @Test
  @DisplayName("회원아이디 존재 여부를 확인한다")
  void existsByNickname() {

    //given
    Users user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when, then
    assertThat(userRepository.existsByNickname(user.getNickname())).isTrue();
  }

  @Test
  @DisplayName("이메일 존재 여부를 확인한다")
  void existsByEmail() {

    //given
    Users user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when, then
    assertThat(userRepository.existsByEmail(user.getEmail())).isTrue();
  }

  @Test
  @DisplayName("회원을 저장하고 조회한다")
  void saveUsers() {

    //given
    Users user = createUser();

    //when
    userRepository.save(user);
    em.flush();
    em.clear();

    //then
    Users findUser = userRepository.findById(user.getId()).orElseThrow(UsersNotFoundException::new);
    assertThat(findUser.getId()).isEqualTo(user.getId());
  }

  @Test
  @DisplayName("생성일을 저장한다")
  void saveBaseTimeEntity() {

    //given
    Users user = createUser();

    //when
    userRepository.save(user);
    em.flush();
    em.clear();

    //then
    Users findUser = userRepository.findById(user.getId()).orElseThrow(UsersNotFoundException::new);

    assertThat(findUser.getCreatedAt()).isNotNull();
    assertThat(findUser.getUpdatedAt()).isNotNull();
  }

  @Test
  @DisplayName("회원아이디가 중복인 경우 예외가 발생한다")
  void throwExceptionByNicknameDuplication() {

    //given
    Users user1 = createUser();
    Users user2 = createOtherUserWithNickname(user1.getNickname());

    userRepository.save(user1);
    em.flush();
    em.clear();

    //when, then
    assertThatThrownBy(() -> {
      userRepository.save(user2);
      em.flush();
      em.clear();
    }).isInstanceOf(PersistenceException.class);
  }

  @Test
  @DisplayName("이메일이 중복인 경우 예외가 발생한다")
  void throwExceptionByEmailDuplication() {

    //given
    Users user1 = createUser();
    Users user2 = createOtherUserWithEmail(user1.getEmail());

    userRepository.save(user1);
    em.flush();
    em.clear();

    //when, then
    assertThatThrownBy(() -> {
      userRepository.save(user2);
      em.flush();
      em.clear();
    }).isInstanceOf(PersistenceException.class);
  }
}