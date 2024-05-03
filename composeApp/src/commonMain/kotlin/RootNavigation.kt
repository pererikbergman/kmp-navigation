import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import arguments.addArgumentExampleScreen
import components.BottomNavigationBarContent
import components.ModalBottomSheetContent
import dialog.DialogExampleScreen
import kotlinx.coroutines.launch
import tab.TabNavScreen

sealed class RootScreen(var route: String, val icon: ImageVector?, var title: String) {
    data object TabNavExample : RootScreen("tab_nav", Icons.Rounded.Home, "Tabs")
    data object DialogExample : RootScreen("dialog", Icons.AutoMirrored.Rounded.List, "Dialog")
    data object Arguments : RootScreen("arguments", Icons.Rounded.Info, "Arguments")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavigation(
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()

    // Bottom Sheet
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("App Navigation") },

                )
        },
        bottomBar = {
            BottomNavigationBarContent(
                navController = navController,
            )
        },
        floatingActionButton = {
            //FloatingActionButton(
            //    onClick = {
            //        showBottomSheet = true
            //    }
            //) {
            //    Icon(Icons.Filled.Add, contentDescription = "")
            //}

            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = RootScreen.TabNavExample.route) {
            addTabNavExampleScreen(Modifier.padding(innerPadding))
            addDialogExampleScreen(Modifier.padding(innerPadding))
            addArgumentExampleScreen(Modifier.padding(innerPadding), navController)
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            ModalBottomSheetContent {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet = false
                    }
                }
            }
        }
    }
}

private fun NavGraphBuilder.addTabNavExampleScreen(modifier: Modifier = Modifier) {
    composable(RootScreen.TabNavExample.route) {
        TabNavScreen(modifier)
    }
}

private fun NavGraphBuilder.addDialogExampleScreen(modifier: Modifier = Modifier) {
    composable(RootScreen.DialogExample.route) {
        DialogExampleScreen(modifier)
    }
}
