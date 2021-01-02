package com.felipe.hrpayroll.resources

import com.felipe.hrpayroll.entities.Payment
import com.felipe.hrpayroll.service.PaymentService
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

    @GetMapping("/{workerId}/days/{days}")
    fun getPayment(@PathVariable workerId: Long, @PathVariable days: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(service.getPayment(workerId, days))
    }
}