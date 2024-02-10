@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.laba1

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
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PestControl
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    val iconWifi = Icons.Default.Wifi
    val iconDevise = Icons.Default.Devices
    val iconApp = Icons.Default.Apps
    val iconNotifications = Icons.Default.Notifications
    val iconPerson = Icons.Default.PestControl
    val iconPhone = Icons.Default.Phone



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
        ListTile(
            title1 = "Get to know your Pixel",
            disc = "Explore what you can do with your phone",
            icon = iconPhone,
            colorBackTile = Color(red = 219, blue = 141, green = 234)
        )
        InputBox(
            text = searchText,
            onTextChange = { },
            onSearchClick = {
                // Handle search action
            }
        )
        ListTile(
            title1 = "Network & Internet",
            disc = "Wi-Fi, Mobile, Data usage, Hotspot",
            icon = iconWifi,
            colorBackTile = Color.Transparent)
        ListTile(
            title1 = "Connected devices",
            disc = "Bluetooth, Cast, NFC",
            icon = iconDevise,
            colorBackTile = Color.Transparent)
        ListTile(
            title1 = "App",
            disc = "Permissions, default apps",
            icon = iconApp,
            colorBackTile = Color.Transparent)
        ListTile(
            title1 = "Notifications",
             disc = "Permissions, default apps",
             icon = iconNotifications,
            colorBackTile = Color.Transparent)
        ListTile(
            title1 = "Digital well being",
            disc = "Screen time, app timer, bedtime schedules",
            icon = iconPerson,
            colorBackTile = Color.Transparent
            )


    }
}

@Composable
fun ListTile(title1: String, disc: String, icon: ImageVector, colorBackTile: Color, modifier: Modifier = Modifier) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 25.dp, top = 20.dp, end = 25.dp, bottom = 20.dp)
        .clip(RoundedCornerShape(50.dp))
    )
    {
        Row(
            modifier = Modifier
            .background(color = colorBackTile)
                .padding(top = 22.dp, bottom = 23.dp, start = 16.dp, end = 16.dp)
        ){
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color(red = 226, blue = 216, green = 227))
            ) {
                Icon(
                    imageVector = icon,
                    tint = Color.Black,
                    contentDescription = "Search",
                    modifier = Modifier
                        .padding(all = 12.dp)

                        .size(24.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 17.dp)
            ) {
                Text(
                    text = title1,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                    )
                Text(text = disc,
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
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

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
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