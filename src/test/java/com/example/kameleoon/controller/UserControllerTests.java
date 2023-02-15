package com.example.kameleoon.controller;

import com.example.kameleoon.dto.RegisterDTO;
import com.example.kameleoon.service.QuoteService;
import com.example.kameleoon.service.UserService;
import com.example.kameleoon.service.VoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;

import static org.mockito.BDDMockito.given;

@WebMvcTest
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;
    @MockBean
    private QuoteService quoteService;
    @MockBean
    private VoteService voteService;

    @Test
    public void givenRegisterDTO_whenCreateUser_thenReturnSavedUser() throws Exception{

        RegisterDTO user = new RegisterDTO("John Doe", "johndoe@example.com", "password");
        given(userService.createUser(any(RegisterDTO.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.name",
                        is(user.getName())))
                .andExpect(jsonPath("$.email",
                        is(user.getEmail())))
                .andExpect(jsonPath("$.password",
                        is(user.getPassword())));

    }
}
