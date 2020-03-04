package model

import kotlinx.serialization.*

@Serializable
data class Geo (
    val lat: String,
    val lng: String
)