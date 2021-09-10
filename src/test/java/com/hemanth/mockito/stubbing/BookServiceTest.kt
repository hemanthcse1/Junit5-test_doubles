package com.hemanth.mockito.stubbing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
public class BookServiceTest {

    @InjectMocks
    private var bookService: BookService? = null

    @Mock
    private var bookRepository: BookRepository? = null

    @Test
    fun testCalculateTotalCostOfBooks() {
        var bookIds: List<String> = listOf("1234", "1235")

        var book1 = Book("1234", "Mockito in action", 500, LocalDate.now())
        var book2 = Book("1235", "JUnit-5 in action", 400, LocalDate.now())

        // Method 1
        //Mockito.`when`(bookRepository?.findBookByBookID("1234")).thenReturn(book1,book1)

        // Method 2
        /*      Mockito.`when`(bookRepository?.findBookByBookID("1234"))
                  .thenReturn(book1)
                  .thenReturn(book1)*/

        // Method 3
        Mockito.`when`(bookRepository?.findBookByBookID("1234")).thenReturn(book1)
        Mockito.`when`(bookRepository?.findBookByBookID("1235")).thenReturn(book2)

        //Method 4
/*        Mockito.doReturn(book1).`when`(bookRepository)?.findBookByBookID("1234")
        Mockito.doReturn(book2).`when`(bookRepository)?.findBookByBookID("1235")*/

        var actualCost = bookService?.calculateTotalConst(bookIds)
        assertEquals(1000, actualCost)

    }

    //UnFinishedStubbing exception


    //Stubout void methods
    @Test
    fun testSaveBook() {
        var book1 = Book(null, "Mockito in action", 500, LocalDate.now())
        var book2 = Book("1235", "JUnit-5 in action", 400, LocalDate.now())

        Mockito.doNothing().`when`(bookRepository)?.save(book1)
        bookService?.addBook(book1)
    }

    @Test
    fun testSaveBookWithBookRequest() {
        var bookRequest = BookRequest("Mockito in action", 500, LocalDate.now())

        var book = Book(null, "Mockito in action", 500, LocalDate.now())
        Mockito.doNothing().`when`(bookRepository)?.save(book)

        bookService?.addBook(bookRequest)
    }

}