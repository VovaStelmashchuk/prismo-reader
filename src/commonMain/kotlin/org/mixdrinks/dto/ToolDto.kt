package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class ToolId(val id: Int)

@Serializable
data class ToolDto(
    @SerialName("id") val id: ToolId,
    @SerialName("name") val name: String,
)
