package com.cbpark.ui.memo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.memo.entity.Memo
import com.cbpark.ui.theme.Paddings

@Composable
fun MemoListUi(
  memos: List<Memo>,
  firstItem: @Composable () -> Unit,
  lastItem: @Composable () -> Unit,
  memoClickEvent: (memo: Memo) -> Unit
) {
  LazyColumn (
    contentPadding = PaddingValues(Paddings.medium),
  ) {
    item { firstItem() }
    itemsIndexed(memos) { index, memo ->
      MemoUi(memo) { memoClickEvent(memo) }
    }
    item { lastItem() }
  }
}

@Preview
@Composable
private fun MemoListUiPrev() {
  val memos = listOf<Memo>(
    Memo(0, "Title1", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(1, "Title2", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(2, "Title3", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(3, "Title4", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(4, "Title5","""
      Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1
      Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1
      Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1
      """.trimIndent()),
    Memo(5, "Title6", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(6, "Title7", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(7, "Title8", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(8, "Title9", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(9, "Title10", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(10, "Title11", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(11, "Title12", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(12, "Title13", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(13, "Title14", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
    Memo(14, "Title15", "Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1Content1"),
  )

  MemoListUi(memos = memos, firstItem = {}, lastItem = {}) {}
}