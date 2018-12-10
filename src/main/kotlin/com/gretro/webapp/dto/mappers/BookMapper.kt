package com.gretro.webapp.dto.mappers

import com.gretro.webapp.dto.BookDto
import com.gretro.webapp.model.Book
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class BookMapper {
    private val modelMapper = ModelMapper()

    fun toDto(model: Book): BookDto {
        return modelMapper.map(model, BookDto::class.java)
    }
}