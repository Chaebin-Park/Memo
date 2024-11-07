package com.cbpark.ui.memo

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.cbpark.memo.core.MainContract
import com.cbpark.memo.viewmodel.MemoViewModel
import com.cbpark.ui.theme.MemoTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MemoPage(
  modifier: Modifier = Modifier,
  memoViewModel: MemoViewModel = hiltViewModel()
) {
  val uiState by memoViewModel.uiState.collectAsState()
  val context = LocalContext.current

  LaunchedEffect(Unit) {
    memoViewModel.effect.collectLatest { effect ->
      when (effect) {
        is MainContract.MemoUiEffect.ShowToast -> {
          Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
        }
      }
    }
  }

  Column(
    modifier = Modifier
      .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    when (uiState) {
      is MainContract.MemoUiState.Content -> {
        val memos = (uiState as MainContract.MemoUiState.Content).memos
        MemoContentPage(memos = memos, memoViewModel = memoViewModel)
      }

      is MainContract.MemoUiState.Error -> {
        Text(text = "Error caused: ${(uiState as MainContract.MemoUiState.Error).message}")
      }

      MainContract.MemoUiState.Loading -> {
        CircularProgressIndicator()
        memoViewModel.setEvent(MainContract.MemoUiEvent.FetchMemo)
      }

      is MainContract.MemoUiState.Write -> {
        val memo = (uiState as MainContract.MemoUiState.Write).memo
        WriteMemoPage(memo = memo, memoViewModel = memoViewModel)
      }
    }
  }
}

@Preview
@Composable
private fun MemoPagePrev() {
  MemoTheme { MemoPage() }
}