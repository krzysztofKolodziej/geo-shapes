package com.example.geo_shapes.controller;

import com.example.geo_shapes.exception.ShapeNotFoundException;
import com.example.geo_shapes.service.ShapeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShapeController.class)
public class ShapeControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ShapeService shapeService;

    @Test
    void shouldReturnNotFound_whenTypeExistsButNoDataInDatabase() throws Exception {
        when(shapeService.getShapes("circle"))
                .thenThrow(new ShapeNotFoundException("circle"));

        mockMvc.perform(get("/api/v1/shapes")
                        .param("type", "circle"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("Not found shape circle"));
    }
}
