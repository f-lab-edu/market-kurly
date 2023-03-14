package com.hello.kurly.restdocs;

import com.hello.kurly.RestDocsConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@MockBean(JpaMetamodelMappingContext.class)
@Import(RestDocsConfiguration.class)
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest
public class RestDocsTest {

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
  void restDocsTest() throws Exception {

    mockMvc.perform(get("/"))
            .andExpect(status().isNotFound())
            .andDo(
                    restDocs.document(
                            //add request and response fields
                    )
            );
  }
}
