package com.tjwogns.tjwogns_android_compose.State

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.tjwogns.tjwogns_android_compose.R
import java.util.*

data class TodoItem (
    val task: String,
    val icon: TodoIcon = TodoIcon.Default,

    val id: UUID = UUID.randomUUID()
)

enum class TodoIcon(val imageVector: ImageVector, @StringRes val contentDescription: Int) {
    Square(Icons.Default.AddCircle, R.string.cd_crop_square),
    Done(Icons.Default.Done, R.string.cd_done),
    Event(Icons.Default.Email, R.string.cd_event),
    Privacy(Icons.Default.Notifications, R.string.cd_privacy),
    Trash(Icons.Default.ShoppingCart, R.string.cd_restore);

    companion object {
        val Default = Square
    }
}