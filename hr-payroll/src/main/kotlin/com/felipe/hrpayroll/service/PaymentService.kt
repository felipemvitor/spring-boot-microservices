package com.felipe.hrpayroll.service

import com.felipe.hrpayroll.entities.Payment
import com.felipe.hrpayroll.entities.Worker
import com.felipe.hrpayroll.feignclients.WorkerFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService {

    @Autowired
    private lateinit var workerFeignClient: WorkerFeignClient

    fun getPayment(workerId: Long, days: Int): Payment {
        val worker: Worker? = workerFeignClient.findById(workerId).body

        return Payment(worker?.name, worker?.dailyIncome, days)
    }
}