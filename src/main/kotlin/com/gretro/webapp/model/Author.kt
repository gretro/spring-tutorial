package com.gretro.webapp.model

import javax.persistence.*

@Entity
class Author(var firstName: String?,
             var lastName: String?,
             @ManyToMany(mappedBy = "authors")
             var books: MutableSet<Book>) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    constructor() : this(null, null, HashSet())
    constructor(firstName: String, lastName: String): this(firstName, lastName, HashSet())

    override fun toString(): String {
        return "Author(firstName=$firstName, lastName=$lastName, books=$books, id=$id)"
    }
}
