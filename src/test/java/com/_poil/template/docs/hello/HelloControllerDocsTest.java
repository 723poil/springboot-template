package com._poil.template.docs.hello;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseBody;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com._poil.template.hello.HelloController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureRestDocs
@WebMvcTest(controllers = HelloController.class)
class HelloControllerDocsTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Hello World!")
    @Test
    void hello() throws Exception {
        // given

        // when & then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/hello"))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("get-hello", preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                responseBody()));
    }
}
