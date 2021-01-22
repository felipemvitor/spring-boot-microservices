package com.felipe.hruser.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        var name: String,

        @Column(unique = true)
        var email: String,

        var password: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "tb_user_role",
                joinColumns = [JoinColumn(name = "user_id")],
                inverseJoinColumns = [JoinColumn(name = "role_id")]
        )
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