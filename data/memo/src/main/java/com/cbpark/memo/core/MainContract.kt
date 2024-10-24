package com.cbpark.memo.core

import com.cbpark.memo.entity.Memo

class MainContract {
  sealed interface MemoUiEvent: UiEvent {
    data object Write: MemoUiEvent
    data class AddMemo(val memo: Memo): MemoUiEvent
    data class ReWrite(val memo: Memo): MemoUiEvent
    data class UpdateMemo(val memo: Memo): MemoUiEvent
    data class DeleteMemo(val memo: Memo): MemoUiEvent
    data object FetchMemo: MemoUiEvent
  }

  sealed interface MemoUiState: UiState {
    data object Loading: MemoUiState
    data class Error(val message: String): MemoUiState
    data class Content(val memos: List<Memo>): MemoUiState
    data class Write(val memo: Memo?): MemoUiState
  }

  sealed interface MemoUiEffect: UiEffect {
    data class ShowToast(val message: String): MemoUiEffect
  }
}