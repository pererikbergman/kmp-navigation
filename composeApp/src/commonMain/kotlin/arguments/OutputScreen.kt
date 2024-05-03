package arguments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OutputScreen(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Hello, $name")

        Button(
            onClick = onClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Go back")
        }
    }
}

@Preview
@Composable
fun OutputScreenPreview() {
    OutputScreen(name = "Per-Erik") {

    }
}