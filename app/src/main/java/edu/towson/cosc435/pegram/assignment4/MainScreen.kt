package edu.towson.cosc435.pegram.assignment4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppMainScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar()
    }
}