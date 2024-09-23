package com.cbpark.memo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cbpark.memo.dao.MemoDao
import com.cbpark.memo.entity.Memo

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDatabase: RoomDatabase() {
  abstract val memoDao: MemoDao
}