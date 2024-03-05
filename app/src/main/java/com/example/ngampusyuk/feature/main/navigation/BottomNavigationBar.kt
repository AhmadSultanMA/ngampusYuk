package com.example.ngampusyuk.feature.main.navigation


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ngampusyuk.ui.theme.CustDarkBlue

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navigationItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Activity,
        BottomNavigationItem.Faq,
        BottomNavigationItem.Profile,
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.LightGray,
        tonalElevation = 24.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navigationItems.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = CustDarkBlue,
                    selectedTextColor = CustDarkBlue,
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.White
                ),
                icon = {
                    if (currentRoute == item.route)
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            tint = CustDarkBlue,
                            modifier = Modifier.size(24.dp)
                        )
                    else
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(24.dp)
                        )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (currentRoute == item.route) CustDarkBlue else Color.Gray
                    )
                },
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.id) {
                            saveState = true
                            inclusive = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentRoute == item.route,
                enabled = currentRoute != item.route,
            )
        }
    }
}