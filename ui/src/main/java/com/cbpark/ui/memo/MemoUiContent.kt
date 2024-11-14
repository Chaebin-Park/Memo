package com.cbpark.ui.memo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.cbpark.memo.entity.Memo
import com.cbpark.ui.theme.MyTypography
import com.cbpark.ui.theme.Paddings

@Composable
fun MemoUiContent(memo: Memo, modifier: Modifier = Modifier) {
  Box (
    modifier = Modifier.padding(Paddings.medium)
  ) {
    Column {
      Text(
        text = memo.title ?: "",
        style = MyTypography.titleSmall
      )
      Spacer(modifier = Modifier.height(Paddings.medium))
      Text(
        text = memo.content,
        style = MyTypography.bodyMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}