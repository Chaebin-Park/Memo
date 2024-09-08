package com.cbpark.memo.core

import com.cbpark.memo.entity.Memo

sealed interface MemoListUiState {
  data object Loading: MemoListUiState
  data object Empty: MemoListUiState
  data class Content(val memos: List<Memo>): MemoListUiState
  data class Error(val message: String): MemoListUiState
}