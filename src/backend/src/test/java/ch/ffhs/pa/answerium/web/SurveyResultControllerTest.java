package ch.ffhs.pa.answerium.web;

import ch.ffhs.pa.answerium.service.SurveyResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class SurveyResultControllerTest {
    final static UUID SURVEY_SECRET_ID = UUID.randomUUID();
    final static String URL = "/api/survey/" + SURVEY_SECRET_ID + "/result/";

    MockMvc mvc;

    @Mock
    SurveyResultService surveyResultService;

    @InjectMocks
    SurveyResultController surveyResultController;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(surveyResultController)
                .build();
    }

    @Test
    void testPostMethodNotAllowed() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post(URL).accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), response.getStatus());
    }


}
