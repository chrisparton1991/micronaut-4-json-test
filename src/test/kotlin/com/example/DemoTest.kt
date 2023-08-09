package com.example

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.annotation.Serdeable
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class DemoTest {

    @Inject
    lateinit var objectMapper: ObjectMapper

    @Test
    fun canWriteEnumLabel() {
        val json = objectMapper.writeValueAsString(TestEnum.FOO)
        assertEquals(""""FooLabel"""", json)
    }

    @Test
    fun canWriteEnumLabelWithinProperty() {
        val json = objectMapper.writeValueAsString(TestObject())
        assertEquals("""{"label":"FooLabel"}""", json)
    }

    /** Tried every possible application of [JsonProperty] below. */
    @Serdeable
    data class TestObject(
        @field:JsonProperty(value = "label")
        @JsonProperty(value = "label")
        val enumValue: TestEnum = TestEnum.FOO,
    )

    @Serdeable
    enum class TestEnum(
        @field:JsonProperty("label")
        @get:JsonProperty("label")
        @JsonProperty("label")
        val label: String
    ) {
        @JsonProperty("label")
        FOO("FooLabel"),
    }
}
