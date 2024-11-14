package com.cbpark.ui.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cbpark.memo.core.MainContract
import com.cbpark.memo.entity.Memo
import com.cbpark.memo.viewmodel.MemoViewModel

@Composable
fun MemoContentPage(
  modifier: Modifier = Modifier,
  memos: List<Memo>,
  memoViewModel: MemoViewModel
) {
  if (memos.isEmpty()) {
    Column {
      Text(text = "No memos available")

      Button(
        onClick = {
          memoViewModel.setEvent(MainContract.MemoUiEvent.Write)
        },
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(text = "Add Memo")
      }
    }
  }
  else MemoListUi(
    memos = memos,
    firstItem = {
      Button(
        onClick = {
          memoViewModel.setEvent(MainContract.MemoUiEvent.Write)
        },
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(text = "Add Memo")
      }
    },
    lastItem = {},
    memoClickEvent = { memo -> memoViewModel.setEvent(MainContract.MemoUiEvent.ReWrite(memo = memo)) },
    memoDeleteEvent = { memo -> memoViewModel.setEvent(MainContract.MemoUiEvent.DeleteMemo(memo = memo)) }
  )
}