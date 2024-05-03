package dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DialogExampleScreen(
    modifier: Modifier = Modifier
) {
    // State to manage the visibility of the dialog
    var showDialog by remember { mutableStateOf(false) }

    // Button to open the dialog
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }
    }

    // Dialog composable that acts as a modal overlay
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            DialogContent {
                showDialog = false
            }
        }
    }
}

@Composable
private fun DialogContent(
    onClose: () -> Unit
) {
    // Material Surface for the dialog content
    Surface {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("This is a modal dialog", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { onClose() }) {
                Text("Close")
            }
        }
    }
}

@Preview
@Composable
fun DialogExampleScreenPreview() {
    DialogExampleScreen()
}

@Preview
@Composable
fun DialogContentPreview() {
    DialogContent {

    }
}
