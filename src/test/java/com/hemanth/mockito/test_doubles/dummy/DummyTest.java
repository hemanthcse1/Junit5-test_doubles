package com.hemanth.mockito.test_doubles.dummy;

import com.hemanth.mockito.test_doubles.dummy.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void testDummy(){
        EmailService emailService = new DummyEmailService();
        BookRespository bookRespository = new FakeBookRepository();
        BookService bookService = new BookService(bookRespository,emailService);

        bookService.addBook(new Book("1234","You can win", 250, LocalDate.now()));
        bookService.addBook(new Book("1235","Mind set", 300, LocalDate.now()));
        bookService.addBook(new Book("1236","Numbers wont lie", 700, LocalDate.now()));

        assertEquals(3,bookService.findNumberOfBooks());
    }
}
