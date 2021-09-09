package com.hemanth.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void testMock(){
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit in action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2,1);
    }

    // Mock test double using mockito
    @Test
    public void testMockWithMockito(){
        BookRespository bookRespository = Mockito.mock(BookRespository.class);
        BookService bookService = new BookService(bookRespository);

        Book book1 = new Book("1234","Mockito in action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit in action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        Mockito.verify(bookRespository,Mockito.times(1)).save(book2);
        Mockito.verify(bookRespository,Mockito.times(0)).save(book1);

    }
}
