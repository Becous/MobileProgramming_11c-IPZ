@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.laba1

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laba1.ui.theme.Laba1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laba1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWindow()
                }
            }
        }
    }
}

@Composable
fun MainWindow(modifier: Modifier = Modifier){
    val searchText by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(bottom = 15.dp, top = 48.dp, end = 22.dp, start = 0.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = "Avtar",
                modifier = Modifier
                    .size(51.dp)
                    .clip(RoundedCornerShape(50.dp))


            )
        }
        Text(
            text = "Settings",
            fontSize = 36.sp,
            modifier = Modifier.padding(start = 12.dp, bottom = 23.dp)

        )
        InputBox(
            text = searchText,
            onTextChange = { },
            onSearchClick = {
                // Handle search action
            }
        )
        ListTile()

    }
}

@Composable
fun ListTile(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
    )
    {
        Row(modifier = Modifier
            .padding(start = 25.dp, top = 20.dp)
            .background(color = Color.Green)
            .clip(RoundedCornerShape(50.dp))
        ){
            Box(
                modifier = modifier
                    .padding(all = 12.dp)
                    .background(color = Color.Gray)
                    .clip(RoundedCornerShape(50.dp))
            ) {
                Icon(

                    imageVector = Icons.Default.Wifi,
                    contentDescription = "Search"
                )
            }
            Text(text = "Hello World")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ListTilePreview(modifier: Modifier = Modifier){
    Laba1Theme {
        MainWindow()

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputBox(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClick: () -> Unit
    ) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier.fillMaxWidth(),
    ){
        TextField(
            value = text,
            onValueChange = { newText ->
                onTextChange(newText)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = { MaterialTheme.typography.bodyLarge },
            placeholder = { MaterialTheme.typography.bodyLarge },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            onTextChange("")
                            keyboardController?.hide()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick()
                    keyboardController?.hide()
                }
            ),
            singleLine = true,
            maxLines = 1
        )
    }

}