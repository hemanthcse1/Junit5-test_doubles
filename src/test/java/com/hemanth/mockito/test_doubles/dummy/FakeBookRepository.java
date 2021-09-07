package com.hemanth.mockito.test_doubles.dummy;

import com.hemanth.mockito.test_doubles.dummy.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRespository{


    Map<String,Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }


    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
