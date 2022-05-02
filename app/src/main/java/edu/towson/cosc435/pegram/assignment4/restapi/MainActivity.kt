package edu.towson.cosc435.pegram.assignment4.restapi

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import dagger.hilt.android.AndroidEntryPoint
import edu.towson.cosc435.pegram.assignment4.restapi.dbstuff.DBViewModel
import edu.towson.cosc435.pegram.assignment4.restapi.dbstuff.DBViewModelFactory
import edu.towson.cosc435.pegram.assignment4.restapi.dbstuff.Entity
import androidx.compose.foundation.layout.Row as Row

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val userState by viewModel.userState.collectAsState()
                    if (userState is UserState.Success) {
                        val users = (userState as UserState.Success).users
                        //UserListView(users)
                        //CallDatabase()
                        AppMainScreen(users)
                    }
                }
            }
        }
    }
}

/*
@Composable
fun UserListView(users: List<Album>) {
    /*
    LazyColumn {
        items(users) { user ->
            AppMainScreen(/*navController = rememberNavController(),*/ user = user)
        }
    }

    LazyColumn {
        items(users) { user ->
            UserItem(navController = rememberNavController(), user = user)
        }
    }

     */
}

@Composable
fun UserItem(navController: NavController, user: Album) {
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
            val context = LocalContext.current
            Button(
                //onClick = { navController.navigate("fullscreen") },
                onClick = { Toast.makeText(context, "Should change screen", Toast.LENGTH_LONG).show() },
                modifier = Modifier.size(100.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
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
*/

val insertSampleData = listOf(
    Entity(Photos("","",""), "", "", ""),
)

@Composable
fun CallDatabase() {
    val context = LocalContext.current
    val simpleViewModel: DBViewModel = viewModel(
        factory = DBViewModelFactory(context.applicationContext as Application)
    )
    simpleViewModel.addSample(insertSampleData)
}