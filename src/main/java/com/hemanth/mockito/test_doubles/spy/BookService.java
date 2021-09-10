package com.hemanth.mockito.test_doubles.spy;

public class BookService {

    private BookRespository bookRespository;

    public BookService(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    public void addBook(Book book){
        if (book.getPrice() > 400){
            return;
        }
        bookRespository.save(book);
    }

}
