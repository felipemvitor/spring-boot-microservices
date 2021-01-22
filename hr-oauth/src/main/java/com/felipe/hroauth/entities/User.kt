package com.felipe.hroauth.entities

import java.io.Serializable

class User(
        var id: Long,
        var name: String,
        var email: String,
        var password: String,
        var roles: Set<Role> = HashSet()
) : Serializable {
    constructor() : this(0, "", "", "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}