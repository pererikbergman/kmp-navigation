import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import arguments.addArgumentExampleScreen
import components.BottomNavigationBarContent
import dialog.DialogExampleScreen
import tab.TabNavScreen

sealed class RootScreen(var route: String, val icon: ImageVector?, var title: String) {
    data object TabNavExample : RootScreen("tab_nav", Icons.Rounded.Home, "Tabs")
    data object DialogExample : RootScreen("dialog", Icons.AutoMirrored.Rounded.List, "Dialog")
    data object Arguments : RootScreen("arguments", Icons.Rounded.Info, "Arguments")
}

@Composable
fun RootNavigation(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBarContent(
                navController = navController,
            )
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = RootScreen.TabNavExample.route) {
            addTabNavExampleScreen(Modifier.padding(innerPadding))
            addDialogExampleScreen(Modifier.padding(innerPadding))
            addArgumentExampleScreen(Modifier.padding(innerPadding), navController)
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
