package com.example.retrofitapp.Navigation.Screens

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.net.toFile
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.retrofitapp.MainViewModel
import java.io.File
import java.lang.NumberFormatException

@Composable
fun HomeScreen(
    navController: NavController
){
    val context = LocalContext.current

    val myViewModel = hiltViewModel<MainViewModel>()

    var num by remember { mutableStateOf("") }

    var name by remember { mutableStateOf("") }

    var slug by remember { mutableStateOf("") }

//    var selectedUri by remember{ mutableStateOf<Uri?>(null) }

//    var selectedUris by remember {
//        mutableStateOf<List<Uri>>(emptyList())
//    }

    var allFilesSelected: MutableList<File> = arrayListOf()

    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            if(it !== null){
                val file = File(context.cacheDir, "image.jpg")

                val inputStream = context.contentResolver.openInputStream(it)

                file.outputStream().use {outputstream ->
                    inputStream!!.copyTo(outputstream)
                }

                myViewModel.uploadImage(file)
            }
        }
    )

    val multiplePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { allUris ->
            if(allUris.isNotEmpty()){
                allUris.forEachIndexed { index, uri ->
                    val file = File(context.cacheDir, "image_${index}.jpg")

                    val inputStream = context.contentResolver.openInputStream(uri)

                    file.outputStream().use {outputstream ->
                        inputStream!!.copyTo(outputstream)
                    }

                    allFilesSelected.add(file)
                }

                myViewModel.uploadMultipleImages(allFilesSelected)
            }
        }
    )

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
                try {
//                    myViewModel.normalRequest2(num.toInt())

                    myViewModel.normalRequest2()

                    Toast.makeText(
                        context,
                        "Fired second bad boy",
                        Toast.LENGTH_SHORT
                    ).show()
                }catch(e: NumberFormatException){
                    Toast.makeText(
                        context,
                        "Type a number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text("Second Request")
        }

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
            Text("Third Request")
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
                myViewModel.normalRequest4("Kofi", "20")

                Toast.makeText(
                    context,
                    "Fired fourth bad boy",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Fourth Request")
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

        Button(onClick = {
            singlePhotoPicker.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }) {
            Text(text = "Select and upload one photo")
        }

        Button(onClick = {
            multiplePhotoPicker.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }) {
            Text(text = "Select and upload multiple photos")
        }

//        AsyncImage(
//            model = selectedUri,
//            contentDescription = null,
//            modifier = Modifier.fillMaxWidth(),
//            contentScale = ContentScale.Fit
//        )

        TextField(
            value = slug,
            onValueChange = {
                slug = it
            },
            label = {
                Text("Picture name without extension")
            },
        )

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                myViewModel.deleteRequest(slug)

                Toast.makeText(
                    context,
                    "Fired defcon",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text("Delete picture request")
        }
    }
}