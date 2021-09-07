package com.hemanth.mockito.test_doubles.stub;

import com.hemanth.mockito.test_doubles.stub.Book;
import com.hemanth.mockito.test_doubles.stub.BookRespository;

import java.time.LocalDate;
import java.util.*;

public class BookRepositoryStub implements BookRespository {

    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }

    @Override
    public List<Book> findNewBooks(int days) {

        List<Book> newBooks = new ArrayList<>();
        Book book1 = new Book("1234","You can win", 250, LocalDate.now());
        Book book2 = new Book("1235","Mind set", 300, LocalDate.now());
        Book book3 = new Book("1236","Numbers wont lie", 700, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);
        newBooks.add(book3);

        return newBooks;
    }
}
