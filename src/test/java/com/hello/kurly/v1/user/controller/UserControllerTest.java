package com.hello.kurly.v1.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.kurly.RestDocsConfiguration;
import com.hello.kurly.v1.user.dto.SignUpRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@MockBean(JpaMetamodelMappingContext.class)
@Import(RestDocsConfiguration.class)
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  protected RestDocumentationResultHandler restDocs;

  @BeforeEach
  void setUp(WebApplicationContext context, RestDocumentationContextProvider provider) {

    this.mockMvc = webAppContextSetup(context)
            .apply(documentationConfiguration(provider))
            .alwaysDo(restDocs)
            .alwaysDo(print())
            .build();
  }

  @Test
  void 회원가입() throws Exception {

    SignUpRequestDto requestDto = new SignUpRequestDto("회원아이디", "회원명", "이메일", "휴대폰번호", "생일", "성별", "비밀번호", "우편번호", "주소", "상세주소");

    mockMvc.perform(post("/v1/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestDto)))
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
                                    fieldWithPath("baseDeliveryAddress").description("기본배송지여부"),
                                    fieldWithPath("deliveryPolicy").description("배송정책"),
                                    fieldWithPath("zipCode").description("우편번호"),
                                    fieldWithPath("address").description("기본주소"),
                                    fieldWithPath("addressDetail").description("상세주소")
                            )
                    )
            );
  }

  @Test
  void getUser() throws Exception {
    //TODO 회원정보 조회
  }

  @Test
  void updateProfile() throws Exception {
    // TODO 회원정보 수정
  }

  @Test
  void getMe() throws Exception {
    // TODO 내정보 조회
  }

  @Test
  void isExistTarget() throws Exception {
    // TODO 존재 여부 확인
  }
}