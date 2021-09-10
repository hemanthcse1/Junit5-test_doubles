package com.hemanth.mockito.test_doubles.mock;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRespository{

    int saveCalled = 0;
    Book lasAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lasAddedBook = book;
    }

    public void verify(Book book, int times){
        assertEquals(times,saveCalled);
        assertEquals(book,lasAddedBook);
    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    public int timesCalled(){
        return saveCalled;
    }

    public boolean calledWith(Book book){
        return lasAddedBook.equals(book);
    }
}
