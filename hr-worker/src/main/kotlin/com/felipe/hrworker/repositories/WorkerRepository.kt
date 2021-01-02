package com.felipe.hrworker.repositories

import com.felipe.hrworker.entities.Worker
import org.springframework.data.jpa.repository.JpaRepository

interface WorkerRepository : JpaRepository<Worker, Long> {
}