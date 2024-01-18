package com.example.testtest.controller;
import com.example.testtest.models.Book;
import com.example.testtest.service.book.BookServiceImpl;
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
class BookControllerTest {

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    void testAddBook() throws Exception {
        Book book = new Book();
        book.setTitle("Sample Book");

        when(bookService.add(book)).thenReturn(book);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/book/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Sample Book\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_CREATED));

        verify(bookService, times(1)).add(book);
    }

    @Test
    void testGetAllBooks() throws Exception {
        when(bookService.getAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        verify(bookService, times(1)).getAll();
    }

    @Test
    void testGetBookById() throws Exception {
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Sample Book");

        when(bookService.getById(bookId)).thenReturn(book);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/getById/{id}", bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Book"));

        verify(bookService, times(1)).getById(bookId);
    }

    @Test
    void testDeleteBookById() throws Exception {
        Long bookId = 1L;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/book/deleteById/{id}", bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.BOOK_DELETED));

        verify(bookService, times(1)).deleteById(bookId);
    }

//    @Test
//    void testGetBooksByGenre() throws Exception {
//        Genre genre = Genre.FICTION;
//        List<Book> books = Collections.singletonList(new Book());
//
//        when(bookService.getByGenre(genre)).thenReturn(books);
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/getByGenre/{genre}", genre))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Sample Book"));
//
//        verify(bookService, times(1)).getByGenre(genre);
//    }

    @Test
    void testGetBooksByLanguage() throws Exception {
        String language = "English";
        List<Book> books = Collections.singletonList(new Book());

        when(bookService.getByLanguage(language)).thenReturn(books);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/getByLanguage/{language}", language))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Sample Book"));

        verify(bookService, times(1)).getByLanguage(language);
    }

//    @Test
//    void testGetBooksByCategory() throws Exception {
//        BookCategory category = BookCategory.LITERATURA_STRAINA;
//        List<Book> books = Collections.singletonList(new Book());
//
//        when(bookService.getByCategory(category)).thenReturn(books);
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/getByCategory/{category}", category))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Sample Book"));
//
//        verify(bookService, times(1)).getByCategory(category);
//    }
}

