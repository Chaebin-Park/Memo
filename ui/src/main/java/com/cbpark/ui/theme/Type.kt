package com.cbpark.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.cbpark.ui.R

private val pretendardExtraBold = FontFamily(
  Font(R.font.pretendard_extrabold, FontWeight.Bold)
)
private val pretendardBold = FontFamily(
  Font(R.font.pretendard_bold, FontWeight.Bold)
)
private val pretendardNormal = FontFamily(
  Font(R.font.pretendard_medium, FontWeight.Normal)
)
private val pretendardThin = FontFamily(
  Font(R.font.pretendard_thin, FontWeight.Thin)
)
private val pretendardExtraThin = FontFamily(
  Font(R.font.pretendard_extralight, FontWeight.Thin)
)

// Set of Material typography styles to start with
val MyTypography = Typography(
  headlineLarge = TextStyle(
    fontFamily = pretendardExtraBold,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
  ),
  headlineMedium = TextStyle(
    fontFamily = pretendardBold,
    fontSize = 24.sp
  ),
  headlineSmall = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp
  ),

  titleLarge = TextStyle(
    fontFamily = pretendardExtraBold,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
  ),
  titleMedium = TextStyle(
    fontFamily = pretendardBold,
    fontSize = 24.sp
  ),
  titleSmall = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp
  ),

  labelLarge = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp,
  ),
  labelMedium = TextStyle(
    fontFamily = pretendardThin,
    fontSize = 16.sp,
  ),
  labelSmall = TextStyle(
    fontFamily = pretendardExtraThin,
    fontSize = 14.sp,
  ),

  bodyLarge = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = pretendardThin,
    fontSize = 16.sp,
  ),
  bodySmall = TextStyle(
    fontFamily = pretendardExtraThin,
    fontSize = 14.sp,
  ),
)

val Typography.underlinedButton: TextStyle
  @Composable get() = labelSmall.copy(
    textDecoration = TextDecoration.Underline
  )

