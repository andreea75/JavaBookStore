package com.example.testtest.controller;
import com.example.testtest.service.shop.ShopServiceImpl;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopControllerTest {

    @Mock
    private ShopServiceImpl shopService;

    @InjectMocks
    private ShopController shopController;

    @Test
    void testBuyBook() throws Exception {
        Long bookId = 1L;
        int quantity = 5;

        when(shopService.buyBook(bookId, quantity));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/shop/{bookId}", bookId)
                        .param("no", String.valueOf(quantity))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Successfully bought 5 books."));

        verify(shopService, times(1)).buyBook(bookId, quantity);
    }

    // Add more tests for different scenarios or edge cases

}
