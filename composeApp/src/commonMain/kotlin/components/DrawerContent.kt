package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DrawerContent(modifier: Modifier = Modifier, onOptionSelected: () -> Unit) {
    ModalDrawerSheet {
        Column(modifier = modifier.fillMaxHeight().padding(16.dp)) {
            NavigationDrawerItem(
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Close Drawer") },
                selected = false,
                onClick = onOptionSelected,
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "Close Drawer") }
            )
        }
    }
}

@Preview
@Composable
fun DrawerContentPreview() {
    DrawerContent {

    }
}