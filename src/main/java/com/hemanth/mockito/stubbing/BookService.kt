package com.hemanth.mockito.stubbing

import java.time.LocalDate

class BookService(
    val bookRepository: BookRepository
) {

    fun getNewBooksWithAppliedDiscount(discountRate: Int, days: Int): List<Book> {
        var newBooks: List<Book> = bookRepository.findNewBooks(days)

        for (book in newBooks) {
            val price = book.price
            val newPrice = price - discountRate * price / 100
            book.price = newPrice
        }
        return newBooks
    }

    fun calculateTotalConst(bookIds: List<String>): Int {
        var total: Int = 0

        for (bookId in bookIds) {
            var book: Book = bookRepository.findBookByBookID(bookId)
            total = total + book.price
        }

        return total
    }

    fun addBook(book: Book) {
        bookRepository.save(book)
    }

    fun addBook(bookRequest: BookRequest) {
        var book = Book(null, bookRequest.title, bookRequest.price, LocalDate.now())
        bookRepository.save(book)

    }

}