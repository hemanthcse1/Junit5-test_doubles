package com.hemanth.mockito.test_doubles.fake;

import java.util.Collection;

public interface BookRespository {
    void save(Book book);
    Collection<Book> findAll();
}
