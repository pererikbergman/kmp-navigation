import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import tab.TabNavScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        TabNavScreen(modifier = Modifier.fillMaxSize())
    }
}