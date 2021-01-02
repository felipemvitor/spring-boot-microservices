package com.felipe.hrpayroll.service

import com.felipe.hrpayroll.entities.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService {

    fun getPayment(workerId: Long, days: Int): Payment {
        return Payment("Bob", 200.0, days)
    }
}