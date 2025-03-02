package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getAdd() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "101").param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1000"));
    }

    @Test
    public void getAddJson() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "101").param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result.value").value("1000"));
    }

    @Test
    public void getMultiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    @Test
    public void getAnd() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "1101").param("operand2", "1011"))
            .andExpect(status().isOk())
            .andExpect(content().string("1001"));
    }

    @Test
    public void getOr() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "1101").param("operand2", "1011"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }
}
