package com.hello.kurly.member.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.kurly.RestDocsConfiguration;
import com.hello.kurly.member.web.dto.DuplicationCheckRequestDto;
import com.hello.kurly.member.web.dto.MemberJoinRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Import(RestDocsConfiguration.class)
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

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
  void checkDuplicationByKeyTest() throws Exception {

    DuplicationCheckRequestDto requestDto = new DuplicationCheckRequestDto("MEMBER_ID", "kurly");

    mockMvc.perform(post("/api/v1/member/duplication-check")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestDto)))
            .andExpect(status().isOk())
            .andDo(
                    restDocs.document(
                            requestFields(
                                    fieldWithPath("key").description("키"),
                                    fieldWithPath("value").description("값")
                            ),
                            responseFields(
                                    fieldWithPath("duplicated").description("중복 여부")
                            )
                    )
            );
  }

  @Test
  void joinTest() throws Exception {

    MemberJoinRequestDto requestDto = new MemberJoinRequestDto("kurly", "1q2w3e4r!@#", "컬리", "marketkuly@kurly.com", "010xxxxxxxx", "서울 영등포구 여의대로 24 (전경련회관)", "ROAD_ADDRESS", "서울 영등포구 여의대로 24 (전경련회관)", "", "07320", "07320", "MOBILE_WEB", "NONE");

    mockMvc.perform(post("/api/v1/member/join")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestDto)))
            .andExpect(status().isOk())
            .andDo(
                    restDocs.document(
                            requestFields(
                                    fieldWithPath("memberId").description("아이디"),
                                    fieldWithPath("password").description("비밀번호"),
                                    fieldWithPath("name").description("이름"),
                                    fieldWithPath("email").description("이메일"),
                                    fieldWithPath("mobileNumber").description("휴대폰 번호"),
                                    fieldWithPath("numberAddress").description("주소1"),
                                    fieldWithPath("baseAddressType").description("주소2"),
                                    fieldWithPath("roadAddress").description("주소3"),
                                    fieldWithPath("subAddress").description("주소4"),
                                    fieldWithPath("zipCode").description("주소5"),
                                    fieldWithPath("zoneCode").description("주소6"),
                                    fieldWithPath("joinInflowType").description("가입 경로"),
                                    fieldWithPath("gender").description("성별")
                            )
                    )
            );
  }

  @Test
  void memberTest() throws Exception {

    mockMvc.perform(get("/api/v1/member")
                    .header("Authorization", "Bearer accessToken"))
            .andExpect(status().isOk())
            .andDo(
                    restDocs.document(
                            requestHeaders(
                                    headerWithName("Authorization").description("Bearer accessToken")
                            ),
                            responseFields(
                                    fieldWithPath("memberNo").description("회원 번호"),
                                    fieldWithPath("memberId").description("아이디"),
                                    fieldWithPath("mobileNo").description("휴대폰 번호"),
                                    fieldWithPath("name").description("이름"),
                                    fieldWithPath("email").description("이메일")
                            )
                    )
            );
  }
}