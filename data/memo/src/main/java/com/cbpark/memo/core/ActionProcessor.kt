package com.cbpark.memo.core

import androidx.core.util.Pair
import kotlinx.coroutines.flow.Flow

interface ActionProcessor<Action, Mutation, Event> {
  operator fun invoke(action: Action): Flow<Pair<Mutation?, Event?>>
}