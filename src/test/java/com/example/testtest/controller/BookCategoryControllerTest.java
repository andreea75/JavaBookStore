package com.example.testtest.controller;
import com.example.testtest.models.BookCategory;
import com.example.testtest.service.book.BookCategoryServiceImpl;
import com.example.testtest.shared.Messages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

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

        when(bookCategoryService.add(any(BookCategory.class))).thenReturn(bookCategory);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/category/createCategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Mystery\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_CATEGORY_CREATED));

        verify(bookCategoryService, times(1)).add(any(BookCategory.class));
    }

    @Test
    void testGetAllCategories() throws Exception {
        when(bookCategoryService.getAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/category/getAll"))
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

        // Provide a return value for the when statement
        when(bookCategoryService.getById(categoryId)).thenReturn(bookCategory);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/category/getById/{id}", categoryId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(categoryId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Mystery"));

        // Verify that the getById method is called with the specified argument
        verify(bookCategoryService, times(1)).getById(categoryId);
    }

    @Test
    void testDeleteCategoryById() throws Exception {
        Long categoryId = 1L;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookCategoryController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/category/deleteById/{id}", categoryId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_CATEGORY_DELETED));

        verify(bookCategoryService, times(1)).deleteById(categoryId);
    }

    // Add more tests for different scenarios or edge cases

}

