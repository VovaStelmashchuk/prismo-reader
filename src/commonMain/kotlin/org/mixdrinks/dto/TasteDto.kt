package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class TasteId(val id: Int)

@Serializable
data class TasteDto(
    @SerialName("id")
    val id: TasteId,
    @SerialName("name")
    val name: String,
)
