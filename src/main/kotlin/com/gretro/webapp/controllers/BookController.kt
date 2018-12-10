package com.gretro.webapp.controllers

import com.gretro.webapp.dto.GetBooksResponse
import com.gretro.webapp.dto.mappers.Mapper
import com.gretro.webapp.repositories.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
        private val mapper: Mapper,
        private val bookRepo: BookRepository) {

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    fun getBooks(): GetBooksResponse {
        val books = bookRepo.findAll().map(mapper::mapToBookDto).toList()
        val response = GetBooksResponse()
        response.books = books

        return response
    }
}