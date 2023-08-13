package com.spring_security6_resource_side.spring_resource_side;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:appplication-test.properties")//use seperate test property if needed
class SpringResourceSideApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    // Initialize your test configuration and beans here if needed

    @BeforeEach
    public void setUp() {
        // Set up any necessary mock objects or configurations before each test
    }

    @Test
    public void testValidAccessTokenAccessResource() throws Exception {
        // Generate a valid access token for testing purposes
        String validAccessToken = "valid-access-token";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/resource")
                        .header("Authorization", "Bearer " + validAccessToken))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Expected resource content"));

        // Add more assertions as needed
    }

    @Test
    public void testInvalidAccessTokenAccessResource() throws Exception {
        // Generate an invalid access token for testing purposes
        String invalidAccessToken = "invalid-access-token";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/resource")
                        .header("Authorization", "Bearer " + invalidAccessToken))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

        // Add more assertions as needed
    }

}
