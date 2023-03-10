package org.mixdrinks.dto

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class FilterDtoGroupDtoTest {

    @Test
    fun `Verify that a filter group can be created from json`() {
        assertEquals(
            @Suppress("MaxLineLength")
            Json.decodeFromString("""{"id":0,"name":"Test","filters":[{"id":0,"name":"Test","cocktailIds":[0]}],"selectionType":"SINGLE"}"""),
            FilterGroupDto(
                id = FilterGroupId(0),
                name = "Test",
                filters = listOf(
                    FilterWithCocktailIdsDto(
                        id = FilterId(0),
                        name = "Test",
                        cocktailIds = listOf(CocktailId(0)).toSet()
                    )
                ),
                selectionType = SelectionType.SINGLE
            )
        )
    }


    @Test
    fun `Verify that a filter group can be created`() {
        val filterDtoGroupWithCocktailIdsDto = FilterGroupDto(
            id = FilterGroupId(0),
            name = "Test",
            filters = listOf(
                FilterWithCocktailIdsDto(
                    id = FilterId(0),
                    name = "Test",
                    cocktailIds = listOf(CocktailId(0)).toSet()
                )
            ),
            selectionType = SelectionType.SINGLE
        )

        assertEquals(
            Json.encodeToString(filterDtoGroupWithCocktailIdsDto),
            """{"id":0,"name":"Test","filters":[{"id":0,"name":"Test","cocktailIds":[0]}],"selectionType":"SINGLE"}"""
        )
    }

    @Test
    fun `Verify that a filter group can be created 2`() {
        val filterDtoGroupWithCocktailIdsDto = FilterGroupDto(
            id = FilterGroupId(0),
            name = "Test",
            filters = listOf(
                FilterWithCocktailIdsDto(
                    id = FilterId(0),
                    name = "Test",
                    cocktailIds = listOf(CocktailId(0)).toSet()
                ),
                FilterWithCocktailIdsDto(
                    id = FilterId(1),
                    name = "Test",
                    cocktailIds = listOf(CocktailId(0), CocktailId(10), CocktailId(20)).toSet()
                )
            ),
            selectionType = SelectionType.MULTIPLE
        )

        assertEquals(
            Json.encodeToString(filterDtoGroupWithCocktailIdsDto),
            @Suppress("MaxLineLength")
            """{"id":0,"name":"Test","filters":[{"id":0,"name":"Test","cocktailIds":[0]},{"id":1,"name":"Test","cocktailIds":[0,10,20]}],"selectionType":"MULTIPLE"}"""
        )
    }
}
