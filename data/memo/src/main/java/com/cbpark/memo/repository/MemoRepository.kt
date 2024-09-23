package com.cbpark.memo.repository

import com.cbpark.memo.dao.MemoDao
import com.cbpark.memo.entity.Memo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MemoRepository {
  fun memos(): Flow<List<Memo>>

  suspend fun insert(memo: Memo)

  suspend fun delete(memo: Memo)

  suspend fun update(memo: Memo)
}