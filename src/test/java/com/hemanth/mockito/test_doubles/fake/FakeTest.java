package com.hemanth.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    // fake test double using mockito
    @Test
    public void testFakeWithMockito(){
        BookRespository bookRespository = Mockito.mock(BookRespository.class);
        BookService bookService = new BookService(bookRespository);

        Book book1 = new Book("1234","Mockito In Action",500,LocalDate.now());
        Book book2 = new Book("1235","Junit 5 In Action",400,LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRespository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
