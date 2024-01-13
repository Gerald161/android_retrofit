package com.example.retrofitapp.Navigation.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.retrofitapp.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController
){
    val context = LocalContext.current

    val myViewModel = hiltViewModel<MainViewModel>()

    var num by remember { mutableStateOf("") }

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.normalRequest()

                Toast.makeText(
                    context,
                    "Fired first bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("First Request")
        }

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.normalRequest2(num.toInt())

                Toast.makeText(
                    context,
                    "Fired second bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Second Request")
        }

        TextField(
            value = num,
            onValueChange = {
                num = it
            },
            label = {
                Text("Type Num")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Send
            ),
        )

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.normalRequest3(name)

                Toast.makeText(
                    context,
                    "Fired third bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Second Request")
        }

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Type Name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Send
            ),
        )

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.normalRequest4("Kofi", "gracias")

                Toast.makeText(
                    context,
                    "Fired third bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Third Request")
        }

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.postRequest("Gerald")

                Toast.makeText(
                    context,
                    "Fired post bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Post Stuff")
        }
    }
}