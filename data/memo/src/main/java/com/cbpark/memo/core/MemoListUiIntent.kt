package com.cbpark.memo.core

sealed interface MemoListUiIntent {
  data object FetchMemoList: MemoListUiIntent
  data object AddMemo: MemoListUiIntent
  data object DeleteMemo: MemoListUiIntent
}