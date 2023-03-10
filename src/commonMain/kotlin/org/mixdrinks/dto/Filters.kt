package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mixdrinks.domain.Filter
import org.mixdrinks.domain.FilterGroup
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class FilterGroupId(val value: Int)

@JvmInline
@Serializable
value class FilterId(val value: Int)

@Serializable
enum class SelectionType {
    @SerialName("SINGLE")
    SINGLE,

    @SerialName("MULTIPLE")
    MULTIPLE
}

@Serializable
data class FilterGroupDto(
    @SerialName("id") val id: FilterGroupId,
    @SerialName("name") val name: String,
    @SerialName("filters") val filters: List<FilterWithCocktailIdsDto>,
    @SerialName("selectionType") val selectionType: SelectionType,
) {
    fun toFilterGroup(): FilterGroup {
        return FilterGroup(
            id = id,
            name = name,
            filters = filters.map {
                Filter(
                    id = it.id,
                    cocktailIds = it.cocktailIds,
                )
            },
        )
    }
}


@Serializable
data class FilterWithCocktailIdsDto(
    @SerialName("id") val id: FilterId,
    @SerialName("name") val name: String,
    @SerialName("cocktailIds") val cocktailIds: Set<CocktailId>,
)
