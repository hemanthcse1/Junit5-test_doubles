package com.hemanth.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StubTest {


    @Test
    void testStub(){
        BookRespository bookRespository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRespository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10,7);

        assertEquals(3,newBooksWithAppliedDiscount.size());
        assertEquals(225,newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(270,newBooksWithAppliedDiscount.get(1).getPrice());

    }

    // stub test doubles using mockito

    @Test
    public void testStubWithMockito(){
        BookRespository bookRespository = Mockito.mock(BookRespository.class);
        BookService bookService = new BookService(bookRespository);

        Book book1 = new Book("1234","Mockito In Action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit 5 In Action",400,LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(bookRespository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10,7);

        assertEquals(2,newBooksWithAppliedDiscount.size());
        assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());

    }
}
