package com.hello.kurly.users.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.kurly.common.exception.NicknameAlreadyExistsException;
import com.hello.kurly.config.RestDocsConfig;
import com.hello.kurly.factory.SignUpRequestFactory;
import com.hello.kurly.users.v1.dto.AddressResponse;
import com.hello.kurly.users.v1.dto.SignUpRequest;
import com.hello.kurly.users.v1.dto.UserResponse;
import com.hello.kurly.users.v1.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Import(RestDocsConfig.class)
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  protected RestDocumentationResultHandler restDocs;

  @MockBean
  private UserService userService;

  @BeforeEach
  void setUp(WebApplicationContext context, RestDocumentationContextProvider provider) {

    this.mockMvc = webAppContextSetup(context)
            .apply(documentationConfiguration(provider))
            .alwaysDo(restDocs)
            .alwaysDo(print())
            .build();
  }

  @Test
  @DisplayName("회원가입을 성공한다")
  void signUp() throws Exception {
    SignUpRequest request = SignUpRequestFactory.createSignUpRequest();
    ArrayList<AddressResponse> addresses = new ArrayList<>();
    addresses.add(new AddressResponse("zipCode1",
                                      "address1",
                                      "addressDetail"));

    when(userService.signUp(any()))
            .thenReturn(new UserResponse(
                    "nickname1",
                    "GENERAL",
                    "name1",
                    addresses)
            );

    mockMvc.perform(post("/v1/users/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(request)))
           .andExpect(status().isOk())
           .andDo(
                   restDocs.document(
                           requestFields(
                                   fieldWithPath("nickname").description("회원아이디"),
                                   fieldWithPath("name").description("회원명"),
                                   fieldWithPath("email").description("이메일"),
                                   fieldWithPath("mobileNumber").description("휴대폰번호"),
                                   fieldWithPath("birthday").description("생일"),
                                   fieldWithPath("gender").description("성별"),
                                   fieldWithPath("password").description("비밀번호"),
                                   fieldWithPath("zipCode").description("우편번호"),
                                   fieldWithPath("address").description("주소"),
                                   fieldWithPath("addressDetail").description("상세주소")
                           ),
                           responseFields(
                                   fieldWithPath("nickname").description("회원아이디"),
                                   fieldWithPath("grade").description("등급"),
                                   fieldWithPath("name").description("회원명"),
                                   fieldWithPath("addresses").description("배송지목록")
                           ).andWithPrefix("addresses.[].",
                                           fieldWithPath("zipCode").description("우편번호"),
                                           fieldWithPath("address").description("기본주소"),
                                           fieldWithPath("addressDetail").description("상세주소")
                           )
                   )
           );
  }

  @Test
  @DisplayName("회원아이디가 이미 존재하는 경우 회원가입을 실패한다")
  void signUp_fail() throws Exception {
    SignUpRequest request = SignUpRequestFactory.createSignUpRequest();

    when(userService.signUp(any()))
            .thenThrow(new NicknameAlreadyExistsException());

    mockMvc.perform(post("/v1/users/signup")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(request)))
           .andExpect(status().isConflict());
  }

  @Test
  void getUser() {
    //TODO 회원정보 조회
  }

  @Test
  void updateProfile() {
    // TODO 회원정보 수정
  }

  @Test
  void getMe() {
    // TODO 내정보 조회
  }

  @Test
  void isExistTarget() {
    // TODO 존재 여부 확인
  }
}