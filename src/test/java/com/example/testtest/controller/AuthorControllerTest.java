package com.example.testtest.controller;
import com.example.testtest.models.Author;
import com.example.testtest.service.author.AuthorServiceImpl;
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
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    private AuthorServiceImpl authorService;

    @InjectMocks
    private AuthorController authorController;

    @Test
    void testAddAuthor() throws Exception {
        Author author = new Author();
        author.setAuthorName("John Doe");

        // Use any() matcher to match any instance of the Author class
        when(authorService.add(any(Author.class))).thenReturn(author);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/author/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"John Doe\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.AUTHOR_CREATED));

        // Verify that the add method is called with any instance of Author
        verify(authorService, times(1)).add(any(Author.class));
    }

    @Test
    void testGetAllAuthors() throws Exception {
        when(authorService.getAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/author/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());


        verify(authorService, times(1)).getAll();
    }

    @Test
    void testGetAuthorById() throws Exception {
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        author.setAuthorName("John Doe");

        when(authorService.getById(authorId)).thenReturn(author);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/author/getById/{id}", authorId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(authorService, times(1)).getById(authorId);
    }

    @Test
    void testDeleteAuthorById() throws Exception {
        Long authorId = 1L;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/author/deleteById/{id}", authorId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.AUTHOR_DELETED));

        verify(authorService, times(1)).deleteById(authorId);
    }

    @Test
    void testGetAuthorsByAuthorName() throws Exception {
        String authorName = "John Doe";
        List<Author> authors = Collections.singletonList(new Author());

        when(authorService.getByAuthorName(authorName)).thenReturn(authors);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/author/getByAuthorName")
                        .param("authorName", authorName))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(authorService, times(1)).getByAuthorName(authorName);
    }
}
