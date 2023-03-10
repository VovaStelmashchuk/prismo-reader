package org

import org.mixdrinks.domain.CocktailSelector
import org.mixdrinks.domain.Filter
import org.mixdrinks.domain.FilterGroup
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.dto.FilterGroupId
import org.mixdrinks.dto.FilterId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CocktailFilterTest {
    @Test
    fun `Verify cocktail filter not handle empty filters`() {
        assertFailsWith<IllegalArgumentException> {
            CocktailSelector(emptyList()).getCocktailIds(emptyMap())
        }
    }

    @Test
    fun `Verify cocktail filter return ids from one filter`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) {
                    add(createFilterItem(11, listOf(11_1, 11_2)))
                    add(createFilterItem(12, listOf(12_1, 12_15)))
                }
            )
        )

        assertEquals(
            setOf(CocktailId(11_1), CocktailId(11_2)),
            cocktailSelector.getCocktailIds(
                mapOf(FilterGroupId(1) to listOf(FilterId(11)))
            )
        )

        assertEquals(
            setOf(CocktailId(12_1), CocktailId(12_15)),
            cocktailSelector.getCocktailIds(
                mapOf(FilterGroupId(1) to listOf(FilterId(12)))
            )
        )
    }

    @Test
    fun `Verify cocktails filter returns ids from several filter`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) {
                    add(createFilterItem(8, listOf(100, 101, 102, 110)))
                    add(createFilterItem(9, listOf(102, 105, 110)))
                }
            )
        )

        assertEquals(
            setOf(CocktailId(102), CocktailId(110)),
            cocktailSelector.getCocktailIds(
                mapOf(FilterGroupId(1) to listOf(FilterId(8), FilterId(9)))
            )
        )
    }

    @Test
    fun `Verify cocktails filter returns ids from few filter and few group result empty list`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) {
                    add(createFilterItem(8, listOf(100, 101, 102, 110)))
                    add(createFilterItem(9, listOf(102, 105, 110)))
                },
                createFilterGroup(2) {
                    add(createFilterItem(18, listOf(102, 110, 105)))
                    add(createFilterItem(9, listOf(100, 101, 102, 110)))
                    add(createFilterItem(90, listOf(99, 88)))
                }
            )
        )

        assertEquals(
            cocktailSelector.getCocktailIds(
                mapOf(
                    FilterGroupId(1) to listOf(FilterId(8), FilterId(9)),
                    FilterGroupId(2) to listOf(FilterId(90))
                )
            ),
            emptySet()
        )
    }

    @Test
    fun `Verify cocktails filter returns ids from few filter and second group add restriction for result`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) { // 102, 110
                    add(createFilterItem(8, listOf(100, 101, 102, 110)))
                    add(createFilterItem(9, listOf(102, 105, 110)))
                },
                createFilterGroup(2) {
                    add(createFilterItem(18, listOf(102, 110, 105)))
                    add(createFilterItem(9, listOf(100, 101, 102)))
                    add(createFilterItem(90, listOf(99, 88)))
                }
            )
        )

        assertEquals(
            setOf(CocktailId(102)),
            cocktailSelector.getCocktailIds(
                mapOf(
                    FilterGroupId(1) to listOf(FilterId(8), FilterId(9)),
                    FilterGroupId(2) to listOf(FilterId(9))
                )
            ),
        )
    }

    @Test
    fun `Verify cocktails filter returns ids from few filters and second group contains all first result`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) {
                    add(createFilterItem(8, listOf(100, 101, 102, 110)))
                    add(createFilterItem(9, listOf(102, 105, 110)))
                },
                createFilterGroup(2) {
                    add(createFilterItem(18, listOf(102, 110, 105)))
                    add(createFilterItem(9, listOf(100, 101, 102, 110)))
                    add(createFilterItem(90, listOf(99, 88)))
                }
            )
        )

        assertEquals(
            setOf(CocktailId(102), CocktailId(110)),
            cocktailSelector.getCocktailIds(
                mapOf(
                    FilterGroupId(1) to listOf(FilterId(8), FilterId(9)),
                    FilterGroupId(2) to listOf(FilterId(18))
                )
            )
        )
    }

    @Test
    fun `Verify cocktails filter case filer don't have any restriction`() {
        val cocktailSelector = CocktailSelector(
            listOf(
                createFilterGroup(1) {
                    add(createFilterItem(8, listOf(100, 101)))
                    add(createFilterItem(9, listOf(100, 101)))
                },
                createFilterGroup(2) {
                    add(createFilterItem(18, listOf(100, 101)))
                    add(createFilterItem(9, listOf(100, 101)))
                    add(createFilterItem(90, listOf(99, 88)))
                }
            )
        )

        assertEquals(
            setOf(CocktailId(100), CocktailId(101)),
            cocktailSelector.getCocktailIds(
                mapOf(
                    FilterGroupId(1) to listOf(FilterId(8), FilterId(9)),
                    FilterGroupId(2) to listOf(FilterId(18))
                )
            )
        )
    }

    private fun createFilterItem(filterId: Int, cocktailIds: List<Int>): Filter {
        return Filter(
            FilterId(filterId),
            cocktailIds.map { CocktailId(it) }.toSet()
        )
    }

    private fun createFilterGroup(
        groupId: Int,
        builderFilter: MutableList<Filter>.() -> Unit
    ): FilterGroup {
        return FilterGroup(
            FilterGroupId(groupId),
            "name",
            buildList(builderFilter)
        )
    }
}
