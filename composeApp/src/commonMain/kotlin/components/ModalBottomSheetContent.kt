package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ModalBottomSheetContent(onClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Button(modifier = Modifier.fillMaxWidth(), onClick = onClose) {
            Text("Hide bottom sheet")
        }
    }
}

@Preview
@Composable
fun ModalBottomSheetContentPreview() {
    ModalBottomSheetContent {

    }
}

