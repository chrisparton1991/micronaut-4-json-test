package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class TestController {

    @Get("/dog")
    fun test1(): HttpResponse<Dog> {
        return HttpResponse.ok(Dog())
    }

    @Get("/animal")
    fun test2(): HttpResponse<Animal> {
        return HttpResponse.ok(Dog())
    }
}

interface Animal {
    val type: String?
}

data class Dog(
    override val type: String = "Dog",
    val legs: Int = 4,
) : Animal
