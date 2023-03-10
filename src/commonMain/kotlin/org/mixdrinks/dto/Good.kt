package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class GoodId(val id: Int)

@Serializable
data class GoodDto(
    @SerialName("id") val id: GoodId,
    @SerialName("name") val name: String,
    @SerialName("about") val about: String,
)
