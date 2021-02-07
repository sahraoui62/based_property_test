package com.softwarecs.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SCSApplication

fun main(args: Array<String>) {
    runApplication<SCSApplication>(*args)
}
