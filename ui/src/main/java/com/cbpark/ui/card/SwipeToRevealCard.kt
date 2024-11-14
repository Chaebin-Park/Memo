package com.cbpark.ui.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.cbpark.ui.theme.Paddings

@Composable
fun SwipeToRevealCard(
  cardContent: @Composable () -> Unit,
  onClick: () -> Unit,
  onDelete: () -> Unit
) {
  var offsetX by remember { mutableFloatStateOf(0f) }
  val animatedOffsetX by animateFloatAsState(targetValue = offsetX, label = "")

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(80.dp)
      .background(Color.Transparent)
  ) {
    // Delete Icon (revealed when swiped)
    Box(
      modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .align(Alignment.CenterEnd)
        .width(80.dp)
        .padding(Paddings.medium)
        .background(Color.Red, shape = RoundedCornerShape(12.dp)),
      contentAlignment = Alignment.CenterEnd
    ) {
      Image(
        modifier = Modifier.padding(end = 12.dp),
        imageVector = Icons.Filled.Delete,
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.White)
      )
    }

    // Card content with swipe functionality
    Card(
      modifier = Modifier
        .padding(Paddings.medium)
        .offset { IntOffset(animatedOffsetX.toInt(), 0) }
        .fillMaxSize()
        .pointerInput(Unit) {
          detectHorizontalDragGestures(
            onDragEnd = {
              if (offsetX < -200f) {
                onDelete()
                offsetX = 0f
              } else {
                offsetX = 0f
              }
            }
          ) { _, dragAmount ->
            val newOffset = offsetX + dragAmount
            offsetX = newOffset.coerceIn(-300f, 0f)
          }
        },
      onClick = onClick,
      shape = RoundedCornerShape(12.dp),
      elevation = CardDefaults.cardElevation(4.dp),
    ) {
      cardContent()
    }
  }
}