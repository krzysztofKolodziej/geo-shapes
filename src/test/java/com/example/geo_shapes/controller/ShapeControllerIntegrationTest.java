package com.example.geo_shapes.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class ShapeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddNewSquare() throws Exception {
        String json = """
                {
                  "type": "square",
                  "parameters": { "a": 10 }
                }
                """;

        mockMvc.perform(post("/api/v1/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Geometric figure added successfully")));
    }

    @Test
    void shouldReturnBadRequestForNegativeParameter() throws Exception {
        String json = """
                {
                  "type": "circle",
                  "parameters": { "radius": -5 }
                }
                """;

        mockMvc.perform(post("/api/v1/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(containsString("positive numbers")));
    }

    @Test
    void shouldReturnBadRequestForInvalidType() throws Exception {
        String json = """
                {
                  "type": "xyz",
                  "parameters": { "a": 5 }
                }
                """;

        mockMvc.perform(post("/api/v1/shapes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldGetShapesByType() throws Exception {
        String json = """
                {
                  "type": "rectangle",
                  "parameters": { "a": 5, "b": 10 }
                }
                """;
        mockMvc.perform(post("/api/v1/shapes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        mockMvc.perform(get("/api/v1/shapes")
                        .param("type", "rectangle"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("RECTANGLE"))
                .andExpect(jsonPath("$[0].parameters.a").value(5));
    }

    @Test
    void shouldReturnBadRequestWhenGettingUnknownShapeType() throws Exception {
        mockMvc.perform(get("/api/v1/shapes")
                        .param("type", "xyz"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Unsupported shape type"));
    }

}
