package com.hemanth.mockito.stubbing

interface BookRepository {

    fun findNewBooks(days: Int): List<Book>
    fun findBookByBookID(bookId: String): Book
    fun save(book: Book)
}