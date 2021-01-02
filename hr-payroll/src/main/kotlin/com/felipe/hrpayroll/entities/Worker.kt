package com.felipe.hrpayroll.entities

import java.io.Serializable

class Worker : Serializable {

    var id: Long? = null
    var name: String = ""
    var dailyIncome: Double = 0.0

    constructor() {
        id = 0
    }

    constructor(id: Long, name: String, dailyIncome: Double) {
        this.id = id
        this.name = name
        this.dailyIncome = dailyIncome
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Worker

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}