package com.cbpark.memo.repository

import com.cbpark.memo.dao.MemoDao
import com.cbpark.memo.entity.Memo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemoRepositoryImpl@Inject constructor(private val dao: MemoDao): MemoRepository {
  override fun memos(): Flow<List<Memo>> = dao.memos()

  override suspend fun insert(memo: Memo) = dao.insert(memo)

  override suspend fun delete(memo: Memo) = dao.delete(memo)

  override suspend fun update(memo: Memo) = dao.update(memo)
}