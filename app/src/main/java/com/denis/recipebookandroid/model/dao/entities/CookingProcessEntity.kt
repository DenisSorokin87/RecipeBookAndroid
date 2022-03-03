package com.denis.recipebookandroid.model.dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CookingProcessEntity(
    @PrimaryKey
    val processId: Int,
    val processNumber: Int,
    val description: String,
)
