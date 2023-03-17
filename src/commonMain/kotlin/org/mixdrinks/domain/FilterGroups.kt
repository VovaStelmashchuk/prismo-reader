package org.mixdrinks.domain

import org.mixdrinks.dto.FilterGroupId
import org.mixdrinks.dto.SelectionType

@Suppress("MagicNumber")
enum class FilterGroups(
    val id: FilterGroupId,
    val translation: String,
    val selectionType: SelectionType,
) {
    TAGS(
        id = FilterGroupId(0),
        translation = "Інше",
        selectionType = SelectionType.MULTIPLE,
    ),
    GOODS(
        id = FilterGroupId(1),
        translation = "Інгрідієнти",
        selectionType = SelectionType.MULTIPLE,
    ),
    TOOLS(
        id = FilterGroupId(2),
        translation = "Приладдя",
        selectionType = SelectionType.MULTIPLE,
    ),
    TASTE(
        id = FilterGroupId(3),
        translation = "Смак",
        selectionType = SelectionType.MULTIPLE,
    ),
    ALCOHOL_VOLUME(
        id = FilterGroupId(4),
        translation = "Алкоголь",
        selectionType = SelectionType.SINGLE,
    ),
    GLASSWARE(
        id = FilterGroupId(5),
        translation = "Стакан",
        selectionType = SelectionType.SINGLE,
    )
}
