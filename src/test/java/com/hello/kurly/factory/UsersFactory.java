package com.hello.kurly.factory;

import com.hello.kurly.users.domain.RoleType;
import com.hello.kurly.users.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsersFactory {

  public static User createUser() {
    return new User("nickname1",
                    "status1",
                    RoleType.ROLE_NORMAL,
                    "grade1",
                    "name1",
                    "email1",
                    "mobileNUmber1",
                    LocalDate.now(),
                    "gender1",
                    "password1",
                    null,
                    new ArrayList<>());
  }

  public static User createOtherUserWithNickname(String nickname) {
    return new User(nickname,
                    "status2",
                    RoleType.ROLE_ADMIN,
                    "grade2",
                    "name2",
                    "email2",
                    "mobileNUmber2",
                    LocalDate.now(),
                    "gender2",
                    "password2",
                    null,
                    new ArrayList<>());
  }

  public static User createOtherUserWithEmail(String email) {
    return new User("nickname2",
                    "status2",
                    RoleType.ROLE_ADMIN,
                    "grade2",
                    "name2",
                    email,
                    "mobileNUmber2",
                    LocalDate.now(),
                    "gender2",
                    "password2",
                    null,
                    new ArrayList<>());
  }
}
