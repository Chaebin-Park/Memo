package com.cbpark.memo.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event: UiEvent, State: UiState, Effect: UiEffect>: ViewModel() {
  private val initialState: State by lazy { createInitialState() }
  abstract fun createInitialState(): State

  private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
  val currentState: State get() = _uiState.value
  val uiState = _uiState.asStateFlow()

  private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
  val event = _event.asSharedFlow()

  private val _effect: Channel<Effect> = Channel()
  val effect = _effect.receiveAsFlow()

  init {
    subscribeEvents()
  }

  private fun subscribeEvents() {
    viewModelScope.launch {
      event.collect{ handelEvent(it) }
    }
  }

  abstract fun handelEvent(event: Event)

  fun setEvent(event: Event) {
    viewModelScope.launch { _event.emit(event) }
  }

  protected fun setState(reducer: (State) -> State) {
    _uiState.value = reducer(_uiState.value)
  }

  protected fun setEffect(effect: Effect) {
    viewModelScope.launch { _effect.send(effect) }
  }
}