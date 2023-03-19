package com.hello.kurly.factory;

import com.hello.kurly.users.domain.RoleType;
import com.hello.kurly.users.domain.Users;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsersFactory {

  public static Users createUser() {
    return new Users("nickname1",
                     "status1",
                     RoleType.ROLE_NORMAL,
                     "grade1",
                     "name1",
                     "email1",
                     "mobileNUmber1",
                     LocalDate.now(),
                     "gender1",
                     "password1",
                     new ArrayList<>());
  }

  public static Users createOtherUserWithNickname(String nickname) {
    return new Users(nickname,
                     "status2",
                     RoleType.ROLE_ADMIN,
                     "grade2",
                     "name2",
                     "email2",
                     "mobileNUmber2",
                     LocalDate.now(),
                     "gender2",
                     "password2",
                     new ArrayList<>());
  }

  public static Users createOtherUserWithEmail(String email) {
    return new Users("nickname2",
                     "status2",
                     RoleType.ROLE_ADMIN,
                     "grade2",
                     "name2",
                     email,
                     "mobileNUmber2",
                     LocalDate.now(),
                     "gender2",
                     "password2",
                     new ArrayList<>());
  }
}
