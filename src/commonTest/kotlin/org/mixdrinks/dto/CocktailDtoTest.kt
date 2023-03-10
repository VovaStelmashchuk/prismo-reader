package org.mixdrinks.dto

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class CocktailDtoTest {

    @Test
    fun `Verify can create from json to cocktail`() {
        val json = """
            {
              "id": 1,
              "name": "Test",
              "receipt": [
                "Test"
              ],
              "goods": [
                {
                  "id": 1,
                  "name": "Test",
                  "amount": 1,
                  "unit": "Test"
                }
              ],
              "tools": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "tags": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "tastes": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "glassware": {
                "id": 1,
                "name": "Test"
              }
            }
        """
        assertEquals(
            Json.encodeToString(
                CocktailDto(
                    id = CocktailId(1),
                    name = "Test",
                    receipt = listOf("Test"),
                    goods = listOf(GoodDto(1, "Test", 1, "Test")),
                    tools = listOf(ToolDto(ToolId(1), "Test")),
                    tags = listOf(TagDto(TagId(1), "Test")),
                    tastes = listOf(TagDto(TagId(1), "Test")),
                    glassware = ToolDto(ToolId(1), "Test"),
                )
            ), json.replace('\n', ' ')
                .replace(" ", "")
                .trim()
        )
    }

    @Test
    fun `Verify that CocktailDto can be serialized`() {
        assertEquals(
            Json.encodeToString(
                CocktailDto(
                    id = CocktailId(1),
                    name = "Test",
                    receipt = listOf("Test"),
                    goods = listOf(GoodDto(1, "Test", 1, "Test")),
                    tools = listOf(ToolDto(ToolId(1), "Test")),
                    tags = listOf(TagDto(TagId(1), "Test")),
                    tastes = listOf(TagDto(TagId(1), "Test")),
                    glassware = ToolDto(ToolId(1), "Test"),
                )
            ), """
            {
              "id": 1,
              "name": "Test",
              "receipt": [
                "Test"
              ],
              "goods": [
                {
                  "id": 1,
                  "name": "Test",
                  "amount": 1,
                  "unit": "Test"
                }
              ],
              "tools": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "tags": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "tastes": [
                {
                  "id": 1,
                  "name": "Test"
                }
              ],
              "glassware": {
                "id": 1,
                "name": "Test"
              }
            }
        """
                .replace('\n', ' ')
                .replace(" ", "")
                .trim()
        )
    }
}
