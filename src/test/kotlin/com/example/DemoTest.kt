package com.example

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.net.URL

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun isRunning() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun canParseDog() {
        URL("http://localhost:8080/dog").openStream().use {
            val json = String(it.readAllBytes())
            assertEquals("""{"type":"Dog","legs":4}""", json)
        }
    }

    @Test
    fun canParseAnimal() {
        URL("http://localhost:8080/animal").openStream().use {
            val json = String(it.readAllBytes())
            assertEquals("""{"type":"Dog","legs":4}""", json)
        }
    }
}
