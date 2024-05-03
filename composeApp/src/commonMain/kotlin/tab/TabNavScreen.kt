package tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TabNavScreen(
    modifier: Modifier = Modifier,
    startTabIdx: Int = 0
) {
    var tabIndex by remember { mutableStateOf(startTabIdx) }
    val tabTitles = listOf("Tab 1", "Tab 2", "Tab 3")

    Column(modifier = modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        when (tabIndex) {
            0 -> Text("Content for Tab 1", modifier = Modifier.padding(16.dp))
            1 -> Text("Content for Tab 2", modifier = Modifier.padding(16.dp))
            2 -> Text("Content for Tab 3", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview
@Composable
fun TabNavScreenPreview() {
    TabNavScreen(startTabIdx = 2)
}