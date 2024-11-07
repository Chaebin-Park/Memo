package com.cbpark.ui.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
  memo: Memo?,
  memoViewModel: MemoViewModel
) {
  val isRewrite by lazy { if (memo != null) true else false }
  var title by remember { mutableStateOf(memo?.title) }
  var content by remember { mutableStateOf(memo?.content) }

  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    TextField(
      value = title?:"",
      onValueChange = { title = it }
    )
    TextField(
      value = content?:"",
      onValueChange = { content = it }
    )

    Row {
      Button(
        onClick = {
          if (isRewrite) {
            memoViewModel.setEvent(MainContract.MemoUiEvent.UpdateMemo(memo!!.copy(title = title?:"", content = content?:"")))
          } else {
            memoViewModel.setEvent(MainContract.MemoUiEvent.AddMemo(Memo(title = title?:"", content = content?:"")))
          }
        },
      ) {
        Text(text = "Save")
      }
      Button(
        onClick = {
          memoViewModel.setEvent(MainContract.MemoUiEvent.FetchMemo)
        },
      ) {
        Text(text = "Cancel")
      }
    }
  }
}