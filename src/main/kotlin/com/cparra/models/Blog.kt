package com.cparra.models

import kotlinx.serialization.Serializable

@Serializable
data class Blog(
    val title: String,
    val author: String,
    val date: String,
    val content: String
)
