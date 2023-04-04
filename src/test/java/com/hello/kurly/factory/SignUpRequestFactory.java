package com.hello.kurly.factory;

import com.hello.kurly.users.v1.dto.SignUpRequest;

public class SignUpRequestFactory {

  public static SignUpRequest createSignUpRequest() {
    return new SignUpRequest("nickname1",
                             "name1",
                             "email1",
                             "mobileNUmber1",
                             "20000101",
                             "gender1",
                             "password1",
                             "zipcode1",
                             "address1",
                             "addressdetail1");
  }
}
