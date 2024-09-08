package com.cbpark.memo.core

interface Reducer<Mutation, UiState> {
  operator fun invoke(mutation: Mutation, currentState: UiState): UiState
}