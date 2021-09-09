package com.hemanth.mockito.test_doubles.spy;

public class BookService {

    private BookRespository bookRespository;

    public BookService(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }

    public void addBook(Book book){
        bookRespository.save(book);
    }

    public int findNumberOfBooks(){
        return bookRespository.findAll().size();
    }
}
