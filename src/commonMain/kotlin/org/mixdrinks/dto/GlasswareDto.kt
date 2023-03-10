package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class GlasswareId(val value: Int)

@Serializable
data class GlasswareDto(
    @SerialName("id")
    val id: GlasswareId,
    @SerialName("name")
    val name: String,
)
