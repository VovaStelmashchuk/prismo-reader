package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SnapshotDto(
    @SerialName("cocktails")
    val cocktails: List<CocktailDto>,
    @SerialName("tools")
    val tools: List<ToolDto>,
    @SerialName("goods")
    val goods: List<GoodDto>,
    @SerialName("tags")
    val tags: List<TagDto>,
    @SerialName("tastes")
    val tastes: List<TasteDto>,
    @SerialName("filterGroups")
    val filterGroups: List<FilterGroupDto>,
    @SerialName("glassware")
    val glassware: List<GlasswareDto>,
)
