package com.cbpark.memo.repository

import com.cbpark.memo.dao.MemoDao
import com.cbpark.memo.entity.Memo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemoRepository @Inject constructor(private val dao: MemoDao) {
  suspend fun memos(): Flow<List<Memo>> = dao.memos()

  suspend fun insert(memo: Memo) = dao.insert(memo)

  suspend fun delete(memo: Memo) = dao.delete(memo)

  suspend fun update(memo: Memo) = dao.update(memo)
}