package com.hemanth.mockito.test_doubles.stub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
