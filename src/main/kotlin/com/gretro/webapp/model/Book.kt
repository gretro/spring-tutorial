package com.gretro.webapp.model

import javax.persistence.*

@Entity
class Book(var title: String?,
           var isbn: String?,
           @ManyToOne
           @JoinColumn(name = "publisher_id", nullable = false, updatable = true)
           var publisher: Publisher,
           @ManyToMany
           @JoinTable(name = "author_book",
                   joinColumns = [JoinColumn(name = "book_id")],
                   inverseJoinColumns = [JoinColumn(name = "author_id")])
           var authors: MutableSet<Author>) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    constructor(title: String, isbn: String, publisher: Publisher) : this(title, isbn, publisher, HashSet())

    override fun toString(): String {
        return "Book(title=$title, isbn=$isbn, publisher=$publisher, authors=$authors, id=$id)"
    }
}