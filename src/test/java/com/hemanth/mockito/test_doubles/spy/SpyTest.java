package com.hemanth.mockito.test_doubles.spy;

import com.hemanth.mockito.test_doubles.spy.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

public class SpyTest {


    @Test
    void testSpy(){
        BookRepositorySpy bookRespositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRespositorySpy);

        Book book1 = new Book("1234","You can win", 500, LocalDate.now());
        Book book2 = new Book("1235","Mind set", 400, LocalDate.now());

        bookService.addBook(book1);
        assertEquals(0,bookRespositorySpy.timesCalled());
        bookService.addBook(book2);

        assertEquals(1,bookRespositorySpy.timesCalled());
        assertTrue(bookRespositorySpy.calledWith(book2));

    }
}
