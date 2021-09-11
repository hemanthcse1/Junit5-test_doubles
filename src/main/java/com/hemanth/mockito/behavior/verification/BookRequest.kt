package com.hemanth.mockito.behavior.verification

import java.time.LocalDate

data class BookRequest(
    var title: String,
    var price: Int,
    var publishedDate: LocalDate
)
