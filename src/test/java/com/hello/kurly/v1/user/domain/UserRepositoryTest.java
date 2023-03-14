package com.hello.kurly.v1.user.domain;

import com.hello.kurly.common.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DataJpaTest
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @PersistenceContext
  EntityManager em;

  User createUser() {
    return new User("nickname1", "status1", RoleType.ROLE_NORMAL, "grade1", "name1", "email1", "mobileNUmber1", LocalDate.now(), "gender1", "password1", new ArrayList<>());
  }

  @Test
  void 회원_저장_성공() {

    //given
    User user = createUser();

    //when
    userRepository.save(user);
    em.flush();
    em.clear();

    //then
    User findUser = userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
    assertThat(findUser.getId()).isEqualTo(user.getId());
  }

  @Test
  void 생성일_저장_성공() {

    //given
    User user = createUser();

    //when
    userRepository.save(user);
    em.flush();
    em.clear();

    //then
    User findUser = userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);

    assertThat(findUser.getCreatedAt()).isNotNull();
    assertThat(findUser.getUpdatedAt()).isNotNull();
  }

  @Test
  void 회원아이디로_회원_조회() {

    //given
    User user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when
    User findUser = userRepository.findByNickname(user.getNickname()).orElseThrow(UserNotFoundException::new);

    //then
    assertThat(findUser.getNickname()).isEqualTo(user.getNickname());
  }

  @Test
  void 이메일로_회원_조회() {

    //given
    User user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when
    User findUser = userRepository.findByEmail(user.getEmail()).orElseThrow(UserNotFoundException::new);

    //then
    assertThat(findUser.getEmail()).isEqualTo(user.getEmail());
  }

  @Test
  void 회원아이디_있는지_확인() {

    //given
    User user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when, then
    assertThat(userRepository.existsByNickname(user.getNickname())).isTrue();
  }

  @Test
  void 이메일_있는지_확인() {

    //given
    User user = userRepository.save(createUser());
    em.flush();
    em.clear();

    //when, then
    assertThat(userRepository.existsByEmail(user.getEmail())).isTrue();
  }

  @Test
  void 회원아이디_중복_예외() {

    //given
    User user1 = createUser();
    User user2 = new User(user1.getNickname(), "status2", RoleType.ROLE_ADMIN, "grade2", "name2", "email2", "mobileNUmber2", LocalDate.now(), "gender2", "password2", new ArrayList<>());

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
  void 이메일_중복_예외() {

    //given
    User user1 = createUser();
    User user2 = new User("nickname2", "status2", RoleType.ROLE_ADMIN, "grade2", "name2", user1.getEmail(), "mobileNUmber2", LocalDate.now(), "gender2", "password2", new ArrayList<>());

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