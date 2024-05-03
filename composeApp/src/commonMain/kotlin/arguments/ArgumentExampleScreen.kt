package arguments

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

sealed class ArgumentScreen(var route: String) {
    data object Input : ArgumentScreen("input")
    data object Output : ArgumentScreen("output/{name}") {
        fun getRoute(name: String) = "output/$name"
    }
}

@Composable
fun ArgumentExampleScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController, startDestination = ArgumentScreen.Input.route) {
        addInputScreen(modifier, navController)
        addOutputScreen(modifier, navController)
    }
}

private fun NavGraphBuilder.addInputScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    composable(ArgumentScreen.Input.route) {
        InputScreen(modifier) { name ->
            navController.navigate(ArgumentScreen.Output.getRoute(if (name.isEmpty()) "John Doe" else name))
        }
    }
}

private fun NavGraphBuilder.addOutputScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    composable(
        ArgumentScreen.Output.route,
        arguments = listOf(navArgument("name") { type = NavType.StringType })
    ) { backStackEntry ->
        val name = backStackEntry.arguments?.getString("name") ?: "John Doe"
        OutputScreen(modifier, name) {
            navController.popBackStack()
        }
    }
}
