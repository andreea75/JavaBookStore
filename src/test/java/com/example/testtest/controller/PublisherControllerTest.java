package com.example.testtest.controller;
import com.example.testtest.models.Publisher;
import com.example.testtest.service.publisher.PublisherServiceImpl;
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
class PublisherControllerTest {

    @Mock
    private PublisherServiceImpl publisherService;

    @InjectMocks
    private PublisherController publisherController;

    @Test
    void testAddPublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherName("ABC Publishers");

        when(publisherService.add(any(Publisher.class))).thenReturn(publisher);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/publisher/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"ABC Publishers\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.PUBLISHER_CREATED));

        verify(publisherService, times(1)).add(any(Publisher.class));
    }

    @Test
    void testGetAllPublishers() throws Exception {
        when(publisherService.getAll()).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/publisher/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        verify(publisherService, times(1)).getAll();
    }

    @Test
    void testGetPublisherById() throws Exception {
        Long publisherId = 1L;
        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        publisher.setPublisherName("ABC Publishers");

        when(publisherService.getById(publisherId)).thenReturn(publisher);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/publisher/getById/{id}", publisherId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(publisherId));

        verify(publisherService, times(1)).getById(publisherId);
    }

    @Test
    void testDeletePublisherById() throws Exception {
        Long publisherId = 1L;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/publisher/deleteById/{id}", publisherId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Messages.PUBLISHER_DELETED));

        verify(publisherService, times(1)).deleteById(publisherId);
    }

    @Test
    void testGetPublishersByPublisherName() throws Exception {
        String publisherName = "ABC Publishers";
        List<Publisher> publishers = Collections.singletonList(new Publisher());

        when(publisherService.getByPublisherName(publisherName)).thenReturn(publishers);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(publisherController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/publisher/getByPublisherName")
                        .param("publisherName", publisherName))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(publisherService, times(1)).getByPublisherName(publisherName);
    }
}

