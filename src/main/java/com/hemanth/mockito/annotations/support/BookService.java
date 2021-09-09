package com.hemanth.mockito.annotations.support;

import java.util.List;

public class BookService {

    private BookRespository bookRespository;

    public BookService(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks = bookRespository.findNewBooks(days);

        for (Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - ((discountRate * price) / 100);
            book.setPrice(newPrice);
        }

        return newBooks;
    }
}
