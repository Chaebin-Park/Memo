package com.cbpark.memo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class Memo(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val title: String,
  val content: String
)
