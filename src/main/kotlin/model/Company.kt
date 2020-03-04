package model

import kotlinx.serialization.*

@Serializable
data class Company (
    val name: String,
    val catchPhrase: String,
    val bs: String
)