package com.cbpark.memo.core

import com.cbpark.memo.entity.Memo

sealed interface MemoListMutation {
  data object ShowLoader: MemoListMutation
  data class ShowMemoList(val memos: List<Memo>): MemoListMutation
  data class ShowError(val message: String): MemoListMutation
}