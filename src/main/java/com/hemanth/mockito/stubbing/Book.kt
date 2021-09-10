package com.hemanth.mockito.stubbing

import java.time.LocalDate

data class Book(
    var bookId: String?,
    var title: String,
    var price: Int,
    var publishedDate: LocalDate
)
