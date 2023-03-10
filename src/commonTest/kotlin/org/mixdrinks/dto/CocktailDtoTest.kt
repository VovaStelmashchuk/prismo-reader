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
                  "goodId": 1,
                  "amount": 50,
                  "unit": "ml"
                }
              ],
              "tools": [1],
              "tags": [1],
              "tastes": [1],
              "glassware":1
            }
        """
        assertEquals(
            Json.encodeToString(
                CocktailDto(
                    id = CocktailId(1),
                    name = "Test",
                    receipt = listOf("Test"),
                    goods = listOf(GoodRelationDto(GoodId(1), 50, "ml")),
                    tools = listOf(ToolId(1)),
                    tags = listOf(TagId(1)),
                    tastes = listOf(TasteId(1)),
                    glassware = GlasswareId(1),
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
                    goods = listOf(GoodRelationDto(GoodId(1), 50, "ml")),
                    tools = listOf(ToolId(1)),
                    tags = listOf(TagId(1)),
                    tastes = listOf(TasteId(1)),
                    glassware = GlasswareId(1),
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
                  "goodId": 1,
                  "amount": 50,
                  "unit": "ml"
                }
              ],
              "tools": [1],
              "tags": [1],
              "tastes": [1],
              "glassware":1
            }
        """
                .replace('\n', ' ')
                .replace(" ", "")
                .trim()
        )
    }
}
