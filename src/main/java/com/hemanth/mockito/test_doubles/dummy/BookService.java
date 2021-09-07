package com.hemanth.mockito.test_doubles.dummy;

public class BookService {

    private BookRespository bookRespository;
    private EmailService emailService;

    public BookService(BookRespository bookRespository, EmailService emailService) {
        this.bookRespository = bookRespository;
        this.emailService = emailService;
    }

    public void addBook(Book book){
        bookRespository.save(book);
    }

    public int findNumberOfBooks(){
        return bookRespository.findAll().size();
    }
}
