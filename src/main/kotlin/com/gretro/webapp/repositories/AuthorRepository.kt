package com.gretro.webapp.repositories

import com.gretro.webapp.model.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: CrudRepository<Author, Long>