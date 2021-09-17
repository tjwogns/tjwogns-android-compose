package com.tjwogns.tjwogns_android_compose

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (Modifier.padding(8.dp)) {
                MainButton(name = "TEST") {
                    openActivity(TestActivity::class.java)
                }
                MainButton("Jetpack Compose basics Codelab") {
                    openActivity(BasicsCodelab::class.java)
                }
                MainButton("Layout Jetpack Compose") {
                    openActivity(LayoutsInJetpackCompose::class.java)
                }
            }
        }
    }

    private fun<T: Activity> openActivity(cls: Class<T>) {
        startActivity(Intent(this, cls))
    }
}

@Composable
fun MainButton(name: String, clickEvent: () -> Unit) {
    Button(
        onClick = clickEvent,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(name)
    }
}