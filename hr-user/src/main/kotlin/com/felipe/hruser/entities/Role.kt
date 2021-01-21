package com.felipe.hruser.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_role")
class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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