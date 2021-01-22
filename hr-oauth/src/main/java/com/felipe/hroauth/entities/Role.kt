package com.felipe.hroauth.entities

import java.io.Serializable

class Role(
        var id: Long,
        var name: String
) : Serializable {

    constructor() : this(0, "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Role

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}