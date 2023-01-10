package ch.ffhs.pa.answerium.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
class AddSurveyParticipationControllerTest {
    static final UUID SURVEY_ID = UUID.randomUUID();
    static final String URL = "/api/survey/" + SURVEY_ID + "/participation/";
    static final UUID PARTICIPATION_ID = UUID.randomUUID();

    MockMvc mvc;

    @InjectMocks
    SurveyParticipationController surveyParticipationController;



    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.standaloneSetup(surveyParticipationController)
                .build();


    }

    @Test
    void testIllegalRequestWithoutBody() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post(URL).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

}
