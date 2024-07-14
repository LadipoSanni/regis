package com.ladiakinson.regis.data;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

// BookControllerTests.java (Controller Tests)
@WebMvcTest(BookController.class)
public class BookControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        // Mock data
        List<Book> mockBooks = Arrays.asList(new Book(1L, "Book 1", "Author 1"), new Book(2L, "Book 2", "Author 2"));
        Mockito.when(bookService.findAllBooks()).thenReturn(mockBooks);

        // Test
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                // Additional assertions
                .andReturn();
    }

    // Other tests for controller endpoints
}
