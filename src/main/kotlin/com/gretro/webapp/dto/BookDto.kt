package com.gretro.webapp.dto

class BookDto {
    var id: Long? = null
    var title: String? = null
    var isbn: String? = null
    var publisher: PublisherDto? = null
    var authors: List<AuthorDto> = ArrayList()
}