package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class TagId(val id: Int)

@Serializable
data class TagDto(
    @SerialName("id")
    val id: TagId,
    @SerialName("name")
    val name: String,
)
