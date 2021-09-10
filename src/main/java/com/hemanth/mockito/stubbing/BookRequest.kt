package com.hemanth.mockito.stubbing

import java.time.LocalDate

data class BookRequest(
    var title: String,
    var price: Int,
    var publishedDate: LocalDate
)
