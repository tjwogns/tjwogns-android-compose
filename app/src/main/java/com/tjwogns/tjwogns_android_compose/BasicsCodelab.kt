package com.tjwogns.tjwogns_android_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BasicsCodelab: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
//                MyScreenContent()
                NameList(names = List(1000) { "Hello Android #$it" })
            }
        }
    }
    
    
    @Composable
    fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
        val counterState = remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxHeight()) {
            Column(modifier = Modifier.weight(1f)){
                for (name in names) {
                    Greeting(name = name)
                    Divider(color = Color.Black)
                }
                Divider(color = Color.Transparent, thickness = 32.dp)
            }
            Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
            )
        }
    }
    
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        Surface(color = Color.Yellow) {
            content()
        }
    }
    
    @Composable
    fun Greeting(name: String) {
        var isSelected by remember { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(targetValue = if (isSelected) Color.Red else Color.Transparent)

        Text(
            text = "Hello $name!",
            modifier = Modifier
                .padding(24.dp)
                .background(color = backgroundColor)
                .clickable(onClick = { isSelected = !isSelected })
        )
    }

    @Composable
    fun Counter(count: Int, updateCount: (Int) -> Unit) {

        Button(
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.White
            )
        ) {
            Text("I've been clicked $count times")
        }
    }

    @Composable
    fun NameList(names: List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(items = names) { name ->
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
    }

    @Preview(showBackground = true, name = "Text preview")
    @Composable
    fun DefaultPreview() {
        MyApp {
            Greeting(name = "Android")
        }
    }

    @Preview(name = "MyScreen preview")
    @Composable
    fun DefaultPreview2() {
        MyApp {
            MyScreenContent()
        }
    }
}


