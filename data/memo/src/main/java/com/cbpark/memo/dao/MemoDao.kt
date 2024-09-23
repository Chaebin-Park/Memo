package com.cbpark.memo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cbpark.memo.entity.Memo
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
  @Insert
  suspend fun insert(memo: Memo)

  @Update
  suspend fun update(memo: Memo)

  @Delete
  suspend fun delete(memo: Memo)

  @Query("SELECT * FROM memo")
  suspend fun memos(): Flow<List<Memo>>
}