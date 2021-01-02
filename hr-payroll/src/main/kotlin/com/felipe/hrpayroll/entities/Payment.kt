package com.felipe.hrpayroll.entities

import java.io.Serializable

class Payment : Serializable {

    var name: String
    var dailyIncome: Double
    var days: Int

    constructor() {
        name = ""
        dailyIncome = 0.0
        days = 0
    }

    constructor(name: String?, dailyIncome: Double?, days: Int?) {
        this.name = name ?: ""
        this.dailyIncome = dailyIncome ?: 0.0
        this.days = days ?: 0
    }

    fun getTotal(): Double {
        return this.days * this.dailyIncome
    }
}