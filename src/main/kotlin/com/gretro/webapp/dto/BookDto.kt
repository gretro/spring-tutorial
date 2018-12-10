package com.gretro.webapp.dto

class BookDto {
    var book: BookInfoDto? = null
    var publisher: PublisherInfoDto? = null
    var authors: List<AuthorInfoDto> = ArrayList()
}