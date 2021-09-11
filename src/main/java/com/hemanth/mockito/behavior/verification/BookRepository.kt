package com.hemanth.mockito.behavior.verification

interface BookRepository {
    fun save(book: Book)
    fun findBookByBookId(bookId: String):Book
}