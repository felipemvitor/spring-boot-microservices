package com.felipe.hrworker.resources

import com.felipe.hrworker.entities.Worker
import com.felipe.hrworker.repositories.WorkerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/workers"])
class WorkerResource {

    companion object {
        private var logger = LoggerFactory.getLogger(WorkerResource::class.java)
    }

    @Autowired
    private lateinit var env: Environment

    @Autowired
    private lateinit var workerRepository: WorkerRepository

    @GetMapping
    fun findAll(): ResponseEntity<List<Worker>> {
        val list = workerRepository.findAll()

        return ResponseEntity.ok(list)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<Worker> {
        logger.info("PORT = " + env.getProperty("local.server.port"))

        val worker = workerRepository.findById(id).get()

        return ResponseEntity.ok(worker)
    }
}