package com.hemanth.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class FakeTest {

    @Test
    public void testFake(){
        BookRespository bookRespository = new FakeBookRepository();
        BookService bookService = new BookService(bookRespository);

        bookService.addBook(new Book("1234","You can win", 250, LocalDate.now()));
        bookService.addBook(new Book("1235","Mind set", 300, LocalDate.now()));
        bookService.addBook(new Book("1236","Numbers wont lie", 700, LocalDate.now()));

        assertEquals(3,bookService.findNumberOfBooks());

    }
}
