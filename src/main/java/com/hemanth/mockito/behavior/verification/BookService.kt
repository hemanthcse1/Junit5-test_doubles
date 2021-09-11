package com.hemanth.mockito.behavior.verification

import com.hemanth.mockito.annotations.support.BookRespository

class BookService(val bookRespository: BookRepository) {

    fun addBook(book: Book) {
        bookRespository.save(book)
    }

    fun addBook(bookRequest: BookRequest) {
        if (bookRequest.price <= 500) {
            return
        }
        var book = Book(
            null,
            bookRequest.title,
            bookRequest.price,
            bookRequest.publishedDate
        )
        bookRespository.save(book)
    }

    fun updatePrice(updatedPrice: Int, bookId: String?){
        if (bookId == null){
            return
        }
        var book:Book = bookRespository.findBookByBookId(bookId)
       /* if (book.price == updatedPrice){
            return
        }*/
        book.price = updatedPrice
        bookRespository.save(book)
    }

}