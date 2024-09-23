package com.cbpark.ui.memo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cbpark.memo.entity.Memo
import com.cbpark.ui.theme.MemoTheme
import com.cbpark.ui.theme.MyTypography
import com.cbpark.ui.theme.Paddings
import com.cbpark.ui.theme.Shapes

@Composable
fun MemoUi(
  memo: Memo,
  modifier: Modifier = Modifier
) {
  Card (
    modifier = modifier.padding(Paddings.medium),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Box (
      modifier = Modifier.padding(Paddings.medium)
    ) {
      Column {
        Text(
          text = memo.title,
          style = MyTypography.titleSmall
        )
        Spacer(modifier = Modifier.height(Paddings.medium))
        Text(
          text = memo.content,
          style = MyTypography.bodyMedium,
          maxLines = 5,
          overflow = TextOverflow.Ellipsis
        )
      }
    }
  }
}

@Preview
@Composable
private fun MemoUiPrev() {
  MemoTheme {
    val memo = Memo(
      id = 0,
      title = "Title test",
      content = """
        content something
        content something
        content something
        content somethingcontent 
        somethingcontent somethingcontent somethingcontent something
        somethingcontent somethingcontent 
        somethingcontent something
      """.trimIndent()
    )
    MemoUi(
      memo = memo,
      modifier = Modifier.fillMaxWidth()
    )
  }
}