package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("srcset") val src: String,
    @SerialName("media") val media: String,
    @SerialName("type") val type: ImageType,
)

@Serializable
enum class ImageType(val imagePrefix: String) {
    @SerialName("cocktails")
    COCKTAIL("cocktails"),

    @SerialName("goods")
    ITEM("goods")
}
