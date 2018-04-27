package com.example.springintokotlin

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Coffee(@Id val id: String? = null, val type: String = "Black Hole Coffee") {
    val code = type.toLowerCase().replace(" ", "-")
}