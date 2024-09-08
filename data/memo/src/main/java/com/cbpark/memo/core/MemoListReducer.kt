package com.cbpark.memo.core

import com.cbpark.memo.entity.Memo

class MemoListReducer : Reducer<MemoListMutation, MemoListUiState> {
  override fun invoke(
    mutation: MemoListMutation,
    currentState: MemoListUiState
  ): MemoListUiState {
    return when (mutation) {
      is MemoListMutation.ShowError -> mutateToShowError(mutation.message)
      MemoListMutation.ShowLoader -> mutateToShowLoader()
      is MemoListMutation.ShowMemoList -> mutateToShowContents(mutation.memos)
    }
  }

  private fun mutateToShowError(message: String): MemoListUiState =
    MemoListUiState.Error(message)

  private fun mutateToShowContents(memos: List<Memo>): MemoListUiState =
    MemoListUiState.Content(memos)

  private fun mutateToShowLoader(): MemoListUiState =
    MemoListUiState.Loading
}