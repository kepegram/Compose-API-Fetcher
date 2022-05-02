package edu.towson.cosc435.pegram.assignment4.restapi

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter

sealed class Routes(val route: String) {
    object Home: Routes("home")
    object AlbumFullScreen : Routes("fullscreen")
}
@Composable
fun HomeScreen(navController: NavController, user: Photos) {
    Row(
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.thumbnailUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
            //val context = LocalContext.current
            Button(
                onClick = { navController.navigate(route = Routes.AlbumFullScreen.route) },
                //onClick = { Toast.makeText(context, "Should change screen", Toast.LENGTH_LONG).show() },
                modifier = Modifier.size(100.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(text = "")
            }
        }
        Column(
            modifier = Modifier.padding(start = 6.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = user.title,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun AlbumScreen(navController: NavController, user: Photos) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        val counter: MutableState<Int> = remember { mutableStateOf(0) }
        Text(
            text = counter.value.toString(),
            modifier = Modifier.padding(16.dp),
        )
        Button(
            onClick = {
                counter.value++
            }
        ) {
            Text(
                text = "CLICK ME!"
            )
        }
        Row(modifier = Modifier.padding(25.dp)) {
            Button(onClick = { navController.navigate("home") }) {
                Text(text = "Return Home")
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController = navController, user = Photos("", "", ""))
        }
        composable(Routes.AlbumFullScreen.route) {
            AlbumScreen(navController = navController, user = Photos("", "", ""))
        }
    }
}