package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class CocktailId(val id: Int)

@Serializable
data class CocktailDto(
    @SerialName("id") val id: CocktailId,
    @SerialName("name") val name: String,
    @SerialName("receipt") val receipt: List<String>,
    @SerialName("goods") val goods: List<GoodId>,
    @SerialName("tools") val tools: List<ToolId>,
    @SerialName("tags") val tags: List<TagId>,
    @SerialName("tastes") val tastes: List<TasteId>,
    @SerialName("glassware") val glassware: GlasswareId,
)

