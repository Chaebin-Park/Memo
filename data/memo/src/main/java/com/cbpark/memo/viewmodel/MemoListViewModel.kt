package com.cbpark.memo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbpark.memo.core.ActionProcessor
import com.cbpark.memo.core.MemoListEvent
import com.cbpark.memo.core.MemoListMutation
import com.cbpark.memo.core.MemoListUiIntent
import com.cbpark.memo.core.MemoListUiState
import com.cbpark.memo.core.Reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MemoListViewModel(
  private val actionProcessor: ActionProcessor<MemoListUiIntent, MemoListMutation, MemoListEvent>,
  private val memoReducer: Reducer<MemoListMutation, MemoListUiState>
): ViewModel() {
  private val _event = MutableSharedFlow<MemoListEvent>()
  private val _state = MutableStateFlow<MemoListUiState>(MemoListUiState.Empty)
  val state = _state.asStateFlow()

  fun processIntent(intent: MemoListUiIntent) {
    viewModelScope.launch {
      actionProcessor(intent).collect { value ->
        val mutation = value.first
        val event = value.second

        mutation?.let(::handelMutation)
        event?.let { _event.tryEmit(it) }
      }
    }
  }

  private fun handelMutation(mutation: MemoListMutation) {
    _state.update {
      memoReducer(mutation, _state.value)
    }
  }
}