package com.cbpark.ui.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cbpark.memo.core.MainContract
import com.cbpark.memo.entity.Memo
import com.cbpark.memo.viewmodel.MemoViewModel

@Composable
fun WriteMemoPage(
  modifier: Modifier = Modifier,
  memo: Memo?,
  memoViewModel: MemoViewModel
) {
  var content by remember { mutableStateOf("") }

  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    Text(text = memo?.content ?: "")

    TextField(
      value = content,
      onValueChange = { content = it }
    )

    Button(
      onClick = {
        memoViewModel.setEvent(MainContract.MemoUiEvent.FetchMemo)
      },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = "Cancel")
    }
  }
}