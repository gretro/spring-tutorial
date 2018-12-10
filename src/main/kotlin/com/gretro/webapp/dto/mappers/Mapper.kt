package com.gretro.webapp.dto.mappers

import com.gretro.webapp.dto.*
import com.gretro.webapp.model.Author
import com.gretro.webapp.model.Book
import com.gretro.webapp.model.Publisher
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component
import java.util.*

@Component
class Mapper {
    private val modelMapper = ModelMapper()

    fun mapToBookInfoDto(model: Book?): BookInfoDto {
        return Optional.ofNullable(model)
                .map { book -> modelMapper.map(book, BookInfoDto::class.java) }
                .orElse(null)
    }

    fun mapToAuthorInfoDto(model: Author?): AuthorInfoDto {
        return Optional.ofNullable(model)
                .map { author ->  modelMapper.map(author, AuthorInfoDto::class.java)}
                .orElse(null)
    }

    fun mapToPublisherInfoDto(model: Publisher?): PublisherInfoDto {
        return Optional.ofNullable(model)
                .map { publisher ->  modelMapper.map(publisher, PublisherInfoDto::class.java)}
                .orElse(null)
    }

    fun mapToBookDto(model: Book): BookDto {
        val dto = BookDto()
        dto.book = mapToBookInfoDto(model)
        dto.publisher = mapToPublisherInfoDto(model.publisher)
        dto.authors = model.authors.map(this::mapToAuthorInfoDto).toList()

        return dto
    }

    fun mapToAuthorDto(model: Author): AuthorDto {
        val dto = AuthorDto()
        dto.authorInfo = mapToAuthorInfoDto(model)
        dto.books = model.books.map(this::mapToBookInfoDto).toList()

        return dto
    }

}