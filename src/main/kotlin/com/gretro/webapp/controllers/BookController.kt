package com.gretro.webapp.controllers

import com.gretro.webapp.dto.BookDto
import com.gretro.webapp.dto.mappers.BookMapper
import com.gretro.webapp.repositories.BookRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
        private val mapper: BookMapper,
        private val bookRepo: BookRepository) {

    @GetMapping("/books")
    fun getBooks(): List<BookDto> {
        return bookRepo.findAll().map(mapper::toDto).toList()
    }
}