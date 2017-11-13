package com.example.springintokotlin

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Duck(@Id val id: String? = null, val type: String = "Generic duck type") {
    val code
            get() = type.toLowerCase().replace(" ", "-")
}
