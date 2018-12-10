package com.gretro.webapp.controllers

import com.gretro.webapp.dto.AuthorDto
import com.gretro.webapp.dto.GetAuthorsResponse
import com.gretro.webapp.dto.mappers.Mapper
import com.gretro.webapp.exceptions.EntityNotFoundException
import com.gretro.webapp.repositories.AuthorRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(
        private val mapper: Mapper,
        private val authorRepo: AuthorRepository) {

    @GetMapping("/authors")
    fun getAuthors(): GetAuthorsResponse {
        val authors = authorRepo.findAll().map(mapper::mapToAuthorInfoDto).toList()
        val response = GetAuthorsResponse()

        response.authors = authors
        return response
    }

    @GetMapping("/authors/{id}")
    fun getAuthor(@PathVariable id: Long): AuthorDto {
        val maybeAuthor = authorRepo.findById(id)
        return maybeAuthor
                .map(mapper::mapToAuthorDto)
                .orElseThrow { EntityNotFoundException("Author", id) }
    }
}