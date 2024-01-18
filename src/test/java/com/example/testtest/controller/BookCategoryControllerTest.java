package com.example.testtest.controller;
import com.example.testtest.models.BookCategory;
import com.example.testtest.service.BookCategoryServiceImpl;
import com.example.testtest.shared.Messages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookCategoryControllerTest {

    @Mock
    private BookCategoryServiceImpl bookCategoryService;

    @InjectMocks
    private BookCategoryController bookCategoryController;

    @Test
    void testCreateCategory() throws Exception {
        BookCategory bookCategory = new BookCategory();
        bookCategory.setName("Mystery");

        when(bookCategoryService.add(bookCategory)).thenReturn(bookCategory);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/book-category/createCategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Mystery\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_CATEGORY_CREATED));

        verify(bookCategoryService, times(1)).add(bookCategory);
    }

    @Test
    void testGetAllCategories() throws Exception {
        when(bookCategoryService.getAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book-category/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        verify(bookCategoryService, times(1)).getAll();
    }

    @Test
    void testGetCategoryById() throws Exception {
        Long categoryId = 1L;
        BookCategory bookCategory = new BookCategory();
        bookCategory.setId(categoryId);
        bookCategory.setName("Mystery");

        when(bookCategoryService.getById(categoryId)).thenReturn(bookCategory);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book-category/getById/{id}", categoryId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(categoryId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Mystery"));

        verify(bookCategoryService, times(1)).getById(categoryId);
    }

    @Test
    void testDeleteCategoryById() throws Exception {
        Long categoryId = 1L;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/book-category/deleteById/{id}", categoryId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_CATEGORY_DELETED));

        verify(bookCategoryService, times(1)).deleteById(categoryId);
    }

    // Add more tests for different scenarios or edge cases

}

