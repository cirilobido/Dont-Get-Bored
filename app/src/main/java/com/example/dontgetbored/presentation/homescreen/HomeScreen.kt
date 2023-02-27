package com.example.dontgetbored.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dontgetbored.presentation.theme.Primary

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .background(Primary)
    ) {

    }
}