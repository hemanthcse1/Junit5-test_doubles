package com.hemanth.mockito.annotations.support;

import com.hemanth.mockito.annotations.support.Book;
import com.hemanth.mockito.annotations.support.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRespository bookRespository;

    @Test
    public void demoCreateMocksUsingAnnotations(){

        Book book1 = new Book("1234","Mockito In Action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit 5 In Action",400, LocalDate.now());

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
