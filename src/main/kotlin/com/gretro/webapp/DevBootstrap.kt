package com.gretro.webapp

import com.gretro.webapp.model.Author
import com.gretro.webapp.model.Book
import com.gretro.webapp.model.Publisher
import com.gretro.webapp.repositories.AuthorRepository
import com.gretro.webapp.repositories.BookRepository
import com.gretro.webapp.repositories.PublisherRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DevBootstrap(
        val authorRepo: AuthorRepository,
        val bookRepo: BookRepository,
        val publisherRepo: PublisherRepository): ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        initData()
    }

    private fun initData() {
        val harperCollins = Publisher("Harper Collins", "123 Smith st, London")
        publisherRepo.save(harperCollins)

        val eric = Author("Eric", "Evans")
        var domainDesign = Book("Domain Driven Design", "1234", harperCollins)
        eric.books.add(domainDesign)
        domainDesign.authors.add(eric)

        authorRepo.save(eric)
        bookRepo.save(domainDesign)

        val worx = Publisher("Worx", "789 John blvd, London")
        publisherRepo.save(worx)

        val rod = Author("Rod", "Johnson")
        val noEJB = Book("J2EE Development without EJB", "23444", worx)
        rod.books.add(noEJB)
        noEJB.authors.add(rod)

        authorRepo.save(rod)
        bookRepo.save(noEJB)
    }
}