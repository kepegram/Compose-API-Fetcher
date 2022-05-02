package edu.towson.cosc435.pegram.assignment4.restapi

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun AppMainScreen(users: List<Photos>) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Assignment 4") },
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        }
    ) {
        Navigation(navController)
        LazyColumn {
            items(users) { user ->
                HomeScreen(navController = rememberNavController(), user = user)
            }
        }
    }
}