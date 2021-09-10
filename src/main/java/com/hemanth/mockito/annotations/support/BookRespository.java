package com.hemanth.mockito.annotations.support;

import java.util.Collection;
import java.util.List;

public interface BookRespository {
    List<Book> findNewBooks(int days);
}
