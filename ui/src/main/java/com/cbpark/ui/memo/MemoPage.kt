package com.cbpark.ui.memo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import com.cbpark.memo.core.MainContract
import com.cbpark.memo.entity.Memo
import com.cbpark.memo.viewmodel.MemoViewModel

@Composable
fun MemoPage(
  memoViewModel: MemoViewModel = hiltViewModel()
) {
  memoViewModel.handelEvent(MainContract.MemoUiEvent.AddMemo(Memo(0, "","")))
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
  Box {

  }
}