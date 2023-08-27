package com.zorac.themis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThemisApplication

fun main(args: Array<String>) {
    runApplication<ThemisApplication>(*args)
}
