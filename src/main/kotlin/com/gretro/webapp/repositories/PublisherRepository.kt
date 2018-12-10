package com.gretro.webapp.repositories

import com.gretro.webapp.model.Publisher
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository: CrudRepository<Publisher, Long> {
}