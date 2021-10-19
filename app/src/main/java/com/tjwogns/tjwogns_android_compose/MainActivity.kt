package com.tjwogns.tjwogns_android_compose

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tjwogns.tjwogns_android_compose.State.UsingStateInJetpackCompose

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
                MainButton("Using state in Jetpack Compose") {
                    openActivity(UsingStateInJetpackCompose::class.java)
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