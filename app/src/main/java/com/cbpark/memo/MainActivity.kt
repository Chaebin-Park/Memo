package com.cbpark.memo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.memo.viewmodel.MemoViewModel
import com.cbpark.ui.memo.MemoPage
import com.cbpark.ui.theme.MemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  private val memoViewModel by viewModels<MemoViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    setContent {
      MemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MemoPage(
            modifier = Modifier.padding(innerPadding),
            memoViewModel = memoViewModel
          )
        }
      }
    }
  }
}