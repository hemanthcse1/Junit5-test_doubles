package com.hemanth.mockito.behavior.verification

import java.time.LocalDate

data class Book(
    var bookId: String?,
    var title: String,
    var price: Int,
    var publishedDate: LocalDate
)
