package com.nick.sampleroomandretrofit.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestModel(
    @PrimaryKey
    var id: Long?,
    var test: String?
) {
}