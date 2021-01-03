package com.felipe.hrpayroll.resources

import com.felipe.hrpayroll.entities.Payment
import com.felipe.hrpayroll.service.PaymentService
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/payments"])
class PaymentResource {

    @Autowired
    private lateinit var service: PaymentService

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(@PathVariable workerId: Long, @PathVariable days: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(service.getPayment(workerId, days))
    }

    fun getPaymentAlternative(workerId: Long, days: Int): ResponseEntity<Payment> {
        val payment = Payment("Brann", 400.0, days)
        return ResponseEntity.ok(payment)
    }
}