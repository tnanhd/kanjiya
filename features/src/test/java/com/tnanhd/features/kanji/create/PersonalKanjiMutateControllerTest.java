//package com.tnanhd.features.kanji.create;
//
//import static org.hamcrest.Matchers.hasItem;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.tnanhd.features.common.ApiResources;
//import com.tnanhd.features.common.PingController;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import tools.jackson.databind.ObjectMapper;
//
//@WebMvcTest(PingController.class)
//class PersonalKanjiMutateControllerTest {
//
//  @Autowired private MockMvc mockMvc;
//  @Autowired private ObjectMapper objectMapper;
//
//  @Test
//  void testAddKanjiSuccess() throws Exception {
//    var payload = AddPersonalKanjiCommand.builder().character("水").build();
//    mockMvc
//        .perform(
//            post(ApiResources.PING)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(payload)))
//        .andDo(print())
//        .andExpect(status().isOk());
//  }
//
//  @Test
//  void testAddKanji_WhenEmptyCharacter_ThenReturnBadRequest() throws Exception {
//    var payload = AddPersonalKanjiCommand.builder().character("").build();
//    mockMvc
//        .perform(
//            post(ApiResources.PING)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(payload)))
//        .andDo(print())
//        .andExpect(status().isBadRequest())
//        .andExpect(jsonPath("$.errors").isArray())
//        .andExpect(jsonPath("$.errors").isNotEmpty())
//        .andExpect(jsonPath("$.errors[*].field").value(hasItem("character")));
//  }
//
//  @Test
//  void testAddKanji_WhenMissingRequestBody_ThenReturnBadRequest() throws Exception {
//    mockMvc
//        .perform(post(ApiResources.PING))
//        .andDo(print())
//        .andExpect(status().isBadRequest())
//        .andExpect(jsonPath("$.detail").value("Required request body is missing"));
//  }
//}
