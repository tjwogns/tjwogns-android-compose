package com.tjwogns.tjwogns_android_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

class LayoutsInJetpackCompose: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            PhotographerCard()
//            LayoutsCodelab()
            ScrollingList()
        }
    }
    
    @Composable
    fun PhotographerCard(modifier: Modifier = Modifier) {
        Row(
            modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = { })
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {

            }
            Column (
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Alfred Sisley", fontWeight = FontWeight.Bold)

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)

                }
            }
        }
    }

    @Composable
    fun LayoutsCodelab() {
        Scaffold(
            topBar = {
                TopAppBar (
                    title = {
                        Text(
                            text = "LayoutsCodelab"
                        )
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    }
                )
            }
        ) { innerPadding ->
            BodyContent(
                Modifier
                    .padding(innerPadding)
                    .padding(8.dp))
        }
    }

    @Composable
    fun SimpleList() {
        val scrollState = rememberScrollState()

        Column(Modifier.verticalScroll(scrollState)) {
            repeat(100) {
                Text("Item #$it")
            }
        }
    }

    @Composable
    fun LazyList() {
        val scrollState = rememberLazyListState()

        LazyColumn(state = scrollState) {
            items(100) {
                ImageListItem(it)
            }
        }
    }

    @Composable
    fun ImageListItem(index: Int) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(
                    data = "https://developer.android.com/images/brand/Android_Robot.png"
                ),
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text("Item #$index", style = MaterialTheme.typography.subtitle1)
        }
    }

    @Composable
    fun ScrollingList() {
        val listSize = 100

        val scrollState = rememberLazyListState()

        val coroutineScope = rememberCoroutineScope()

        Column {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Text("Scroll to the top")
                }
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }) {
                    Text("Scroll to the end")
                }

            }
            LazyColumn(state = scrollState) {
                items(listSize) {
                    ImageListItem(index = it)
                }
            }
        }
    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(text = "Hi there!")
            Text(text = "Thanks for going through the Layouts codelab")
        }
    }

    @Preview
    @Composable
    fun LayoutsCodelabPreview() {
        LayoutsCodelab()
    }

    @Preview
    @Composable
    fun PhotographerCardPreview() {
        PhotographerCard()
    }
}


