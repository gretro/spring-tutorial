package com.gretro.webapp.model

import javax.persistence.*

@Entity
class Publisher(
        var name: String?,
        var address: String?,
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "publisher")
        var books: MutableSet<Book>) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    constructor(): this(null, null, HashSet())
    constructor(name: String, address: String): this(name, address, HashSet())

    override fun toString(): String {
        return "Publisher(name=$name, address=$address, id=$id)"
    }
}