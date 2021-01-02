package com.felipe.hrpayroll.service

import com.felipe.hrpayroll.entities.Payment
import com.felipe.hrpayroll.entities.Worker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PaymentService {

    @Value("\${hr-worker.host}")
    private lateinit var workerHost: String

    @Autowired
    private lateinit var restTemplate: RestTemplate

    fun getPayment(workerId: Long, days: Int): Payment {
        val uriVariables = HashMap<String, String>()
        uriVariables["id"] = workerId.toString()

        val worker: Worker? = restTemplate.getForObject("$workerHost/workers/{id}", Worker::class.java, uriVariables)

        return Payment(worker?.name, worker?.dailyIncome, days)
    }
}