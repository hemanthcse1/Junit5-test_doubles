package com.hemanth.mockito.test_doubles.spy;

import com.hemanth.mockito.test_doubles.spy.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

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

    // spy test doubles using mockito

    @Test
    public void testSpyWithMockito(){
        BookRespository bookRespository = Mockito.spy(BookRespository.class);
        BookService bookService = new BookService(bookRespository);

        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit in action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        Mockito.verify(bookRespository,Mockito.times(1)).save(book2);
        Mockito.verify(bookRespository,Mockito.times(0)).save(book1);

    }
}
