package com.hemanth.mockito.test_doubles.spy;

import com.hemanth.mockito.test_doubles.spy.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

    @Test
    void demoSpy(){

        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit in action",400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2,bookRepositorySpy.timesCalled());
        assertTrue(bookRepositorySpy.calledWith(book2));

    }
}
