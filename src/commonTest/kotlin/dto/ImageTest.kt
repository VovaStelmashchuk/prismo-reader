package dto

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class ImageTest {

    @Test
    fun verifyCreateJson() {
        assertEquals(
            Json.encodeToString(
                Image(
                    "src",
                    "media",
                    ImageType.COCKTAIL
                )
            ), """{"srcset":"src","media":"media","type":"cocktails"}"""
        )
    }

    @Test
    fun verifyCreateObject() {
        assertEquals(
            Json.decodeFromString(
                """{"srcset":"src","media":"media","type":"cocktails"}"""
            ), Image(
                "src",
                "media",
                ImageType.COCKTAIL
            )
        )
    }
}
