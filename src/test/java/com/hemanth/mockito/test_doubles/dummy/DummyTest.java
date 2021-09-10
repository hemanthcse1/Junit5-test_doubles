package com.hemanth.mockito.test_doubles.dummy;

import com.hemanth.mockito.test_doubles.dummy.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    // dummy test doubles using mockito

    @Test
    public void testDummyWithMockito(){
        EmailService emailService = Mockito.mock(EmailService.class);
        BookRespository bookRespository = Mockito.mock(BookRespository.class);
        BookService bookService = new BookService(bookRespository,emailService);

        Book book1 = new Book("1234","Mockito in Action",500,LocalDate.now());
        Book book2 = new Book("1235","Junit 5 in action", 400,LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRespository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
