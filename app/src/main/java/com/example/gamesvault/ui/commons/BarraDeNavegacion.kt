package com.example.gamesvault.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gamesvault.ui.screens.navigationItems

@Composable
fun BarraDeNavegacion(
    navController: NavHostController
) {
    // Estado para el índice seleccionado
    var selectedNavigationIndex by remember { mutableStateOf(0) }

    // Obtener la ruta actual desde el NavController
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Sincronizar el índice con la ruta activa
    navBackStackEntry?.destination?.route?.let { currentRoute ->
        selectedNavigationIndex = navigationItems.indexOfFirst { it.route == currentRoute }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF020817))
            .drawBehind {
                drawLine(
                    color = Color(0xff121B2B),
                    strokeWidth = 1.dp.toPx(),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f)
                )
            }
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            tonalElevation = 0.dp
        ) {
            // Iteramos por los items de navegación
            navigationItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedNavigationIndex == index,
                    onClick = {
                        // Actualizar el índice y navegar
                        selectedNavigationIndex = index
                        if (item.route.isNotEmpty()) {
                            navController.navigate(item.route)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icono,
                            contentDescription = item.titulo,
                            tint = if (selectedNavigationIndex == index) Color(0xFF7C3AED) else Color.White
                        )
                    },
                    label = {
                        Text(
                            item.titulo,
                            color = if (selectedNavigationIndex == index) Color(0xFF7C3AED) else Color.White
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF7C3AED),
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}
