package com.cbpark.memo.viewmodel

import androidx.lifecycle.viewModelScope
import com.cbpark.memo.core.BaseViewModel
import com.cbpark.memo.core.MainContract
import com.cbpark.memo.entity.Memo
import com.cbpark.memo.repository.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(
  private val repository: MemoRepository
): BaseViewModel<MainContract.MemoUiEvent, MainContract.MemoUiState, MainContract.MemoUiEffect>() {
  override fun createInitialState(): MainContract.MemoUiState = MainContract.MemoUiState.Loading

  override fun handelEvent(event: MainContract.MemoUiEvent) {
    when(event) {
      is MainContract.MemoUiEvent.AddMemo -> addMemo(memo = event.memo)
      is MainContract.MemoUiEvent.DeleteMemo -> deleteMemo(memo = event.memo)
      MainContract.MemoUiEvent.FetchMemo -> fetchMemos()
      is MainContract.MemoUiEvent.UpdateMemo -> updateMemo(memo = event.memo)
      is MainContract.MemoUiEvent.ReWrite -> TODO()
      MainContract.MemoUiEvent.Write -> TODO()
    }
  }

  private fun addMemo(memo: Memo) {
    viewModelScope.launch {
      try {
        setState { MainContract.MemoUiState.Loading }
        repository.insert(memo)
        fetchMemos()
        setEffect(MainContract.MemoUiEffect.ShowToast("memo added"))
      } catch (e: Exception) {
        setState { MainContract.MemoUiState.Error("add error: ${e.message}") }
      }
    }
  }

  private fun deleteMemo(memo: Memo) {
    viewModelScope.launch {
      try {
        setState { MainContract.MemoUiState.Loading }
        repository.delete(memo)
        fetchMemos()
        setEffect(MainContract.MemoUiEffect.ShowToast("memo deleted"))
      } catch (e: Exception) {
        setState { MainContract.MemoUiState.Error("delete error: ${e.message}") }
      }
    }
  }

  private fun updateMemo(memo: Memo) {
    viewModelScope.launch {
      try {
        setState { MainContract.MemoUiState.Loading }
        repository.update(memo)
        fetchMemos()
        setEffect(MainContract.MemoUiEffect.ShowToast("memo updated"))
      } catch (e: Exception) {
        setState { MainContract.MemoUiState.Error("update error: ${e.message}") }
      }
    }
  }

  private fun fetchMemos() {
    viewModelScope.launch {
      try {
        setState { MainContract.MemoUiState.Loading }

        repository.memos().collect { memos ->
          setState { MainContract.MemoUiState.Content(memos) }
        }
      } catch (e: Exception) {
        setState { MainContract.MemoUiState.Error("fetch error: ${e.message}") }
      }
    }
  }
}