package com.felipe.hrworker.resources

import com.felipe.hrworker.entities.Worker
import com.felipe.hrworker.repositories.WorkerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/workers"])
class WorkerResource {

    @Autowired
    private lateinit var workerRepository: WorkerRepository

    @GetMapping
    fun findAll(): ResponseEntity<List<Worker>> {
        val list = workerRepository.findAll()

        return ResponseEntity.ok(list)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<Worker> {
        val worker = workerRepository.findById(id).get()

        return ResponseEntity.ok(worker)
    }
}