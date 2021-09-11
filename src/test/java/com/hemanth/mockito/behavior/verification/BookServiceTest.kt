package com.hemanth.mockito.behavior.verification

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
class BookServiceTest {

    @InjectMocks
    private val bookService: BookService? = null

    @Mock
    private val bookRepository: BookRepository? = null

    @Test
    fun testAddBook(){
        val book = Book(null,"Mockito in action",500, LocalDate.now())
        bookService?.addBook(book)
        Mockito.verify(bookRepository)?.save(book)
    }

    @Test
    fun testSaveBookWithBookRequestWithGreaterPrice(){
        var bookRequest = BookRequest("Mockito In Action",500, LocalDate.now())
        var book = Book(null,"Mockito In Action",500, LocalDate.now())
        bookService?.addBook(bookRequest)
        Mockito.verify(bookRepository,Mockito.times(0))?.save(book)
    }

    @Test
    fun testSaveBookWithBookRequestWithGreaterPriceByCallingTwice(){
        var bookRequest = BookRequest("Mockito In Action",600, LocalDate.now())
        var book = Book(null,"Mockito In Action",600, LocalDate.now())
        bookService?.addBook(bookRequest)
        bookService?.addBook(bookRequest)
        Mockito.verify(bookRepository,Mockito.times(2))?.save(book)
    }

    // Mockito.never()
    @Test
    fun testSaveBookWithBookRequestWithGreaterPriceUsingNever(){
        var bookRequest = BookRequest("Mockito In Action",500, LocalDate.now())
        var book = Book(null,"Mockito In Action",500, LocalDate.now())
        bookService?.addBook(bookRequest)
        Mockito.verify(bookRepository,Mockito.never())?.save(book)
    }

    // verifyNoInteractions
    @Test
    fun testUpdatePrice(){
        bookService?.updatePrice(600,null)
        Mockito.verifyNoInteractions(bookRepository)
    }

    // verifyNoMoreInteractions
    @Test
    fun testUpdatePrice1(){
        var book = Book("1234","Mockiot In Action",500, LocalDate.now())
        Mockito.`when`(bookRepository?.findBookByBookId("1234")).thenReturn(book)
        bookService?.updatePrice(500,"1234")
        Mockito.verify(bookRepository)?.findBookByBookId("1234")
        Mockito.verify(bookRepository)?.save(book)
        Mockito.verifyNoMoreInteractions(bookRepository)
    }

    // Verification InOrder
    @Test
    fun testUpdatePrice2(){
        var book = Book("1234","Mockiot In Action",500, LocalDate.now())
        Mockito.`when`(bookRepository?.findBookByBookId("1234")).thenReturn(book)
        bookService?.updatePrice(500,"1234")

        var inOrder: InOrder = Mockito.inOrder(bookRepository)

        inOrder.verify(bookRepository)?.findBookByBookId("1234")
        inOrder.verify(bookRepository)?.save(book)
    }

    // Mockito.atLeast(), Mockito.atMost(), Mockito.atMostOnce(), Mockito.atLeastOnce()
    @Test
    fun testSaveBookWithBookRequestWithGreaterPriceByCallingTwice3(){
        var bookRequest = BookRequest("Mockito In Action",600, LocalDate.now())
        var book = Book(null,"Mockito In Action",600, LocalDate.now())
        bookService?.addBook(bookRequest)
        bookService?.addBook(bookRequest)
        bookService?.addBook(bookRequest)
        //Mockito.verify(bookRepository,Mockito.times(2))?.save(book)
        //Mockito.verify(bookRepository,Mockito.atLeast(2))?.save(book)
        //Mockito.verify(bookRepository,Mockito.atMost(4))?.save(book)
        //Mockito.verify(bookRepository,Mockito.atMostOnce())?.save(book)
        Mockito.verify(bookRepository,Mockito.atLeastOnce())?.save(book)
    }



}