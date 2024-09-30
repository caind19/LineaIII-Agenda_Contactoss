package com.example.agendac.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Composable que muestra una barra de navegación inferior para la aplicación.
 * Esta barra permite la navegación entre dos pantallas principales:
 * - La pantalla de añadir un contacto
 * - La pantalla de la lista de contactos
 *
 * @param navController Controlador de navegación usado para navegar entre pantallas.
 */
@Composable
fun BottomNavigationBar(navController: NavController) {
    // Definimos los elementos de navegación, cada uno tiene una ruta, un título (label) y un ícono.
    val items = listOf(
        BottomNavItem(
            route = "form",              // Ruta para la pantalla de añadir contacto
            label = "Añadir Contacto",    // Texto que aparece debajo del ícono
            icon = Icons.Default.Add      // Ícono de "Añadir"
        ),
        BottomNavItem(
            route = "list",              // Ruta para la pantalla de la lista de contactos
            label = "Lista de Contactos", // Texto que aparece debajo del ícono
            icon = Icons.Default.List     // Ícono de "Lista"
        )
    )

    // NavigationBar es un componente de Material Design que crea una barra de navegación inferior.
    NavigationBar {
        // Obtiene la entrada actual de la pila de navegación para saber en qué pantalla estamos.
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        // Para cada elemento en la lista de elementos de navegación (form, list)
        items.forEach { item ->
            // NavigationBarItem es el componente que define cada ítem de la barra de navegación.
            NavigationBarItem(
                label = { Text(item.label) },  // Texto que describe el ítem
                icon = { Icon(item.icon, contentDescription = item.label) }, // Ícono asociado al ítem
                selected = currentRoute == item.route, // Marca como seleccionado si la ruta actual coincide con la del ítem
                onClick = {
                    // Acción a realizar cuando se hace clic en un ítem:
                    // - Navegar a la ruta del ítem seleccionado
                    // - popUpTo(navController.graph.startDestinationId): Esto asegura que al hacer clic
                    //   en un ítem, se "limpian" las pantallas previas para evitar que la pila de navegación
                    //   se llene de pantallas antiguas.
                    // - launchSingleTop: Previene que se creen múltiples instancias de la misma pantalla en la pila de navegación.
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

/**
 * Clase de datos que representa un ítem de la barra de navegación inferior.
 *
 * @param route Ruta de la pantalla a la que navega este ítem.
 * @param label Texto que se muestra debajo del ícono en la barra de navegación.
 * @param icon Ícono que representa el ítem en la barra de navegación.
 */
data class BottomNavItem(
    val route: String, // La ruta de la pantalla asociada al ítem de la barra de navegación
    val label: String, // Texto que se mostrará como etiqueta del ítem
    val icon: androidx.compose.ui.graphics.vector.ImageVector // Ícono que se mostrará en la barra de navegación
)