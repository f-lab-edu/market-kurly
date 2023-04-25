package com.hello.kurly.factory;

import com.hello.kurly.users.domain.GradeType;
import com.hello.kurly.users.domain.RoleType;
import com.hello.kurly.users.domain.StatusType;
import com.hello.kurly.users.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserFactory {

  public static User createUser() {
    return new User("nickname1",
                    StatusType.NORMAL,
                    RoleType.NORMAL,
                    GradeType.GENERAL,
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
                    StatusType.NORMAL,
                    RoleType.ADMIN,
                    GradeType.GENERAL,
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
                    StatusType.NORMAL,
                    RoleType.ADMIN,
                    GradeType.GENERAL,
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
