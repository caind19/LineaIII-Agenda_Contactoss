package com.example.agendac.navegacion

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.agendac.screens.ContactFormScreen
import com.example.agendac.screens.ContactListScreen
import com.example.agendac.navegacion.BottomNavigationBar

@Composable
fun NavigationExample() {
    val navController = rememberNavController() // Creamos el controlador de navegación

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController) // Barra de navegación inferior con botones para dirigirse a lista de contactos y añadir contacto
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "list", // Definimos la lista de contactos como pantalla de inicio
            modifier = Modifier.padding(innerPadding)
        ) {
            // Pantalla para mostrar la lista de contactos
            composable("list") {
                ContactListScreen(navController)
            }

            // Pantalla para agregar nuevos contactos (sin ID)
            composable("form") {
                ContactFormScreen(navController)
            }

            // Pantalla para editar contactos existentes (con ID)
            composable(
                "form/{contactId}",
                arguments = listOf(navArgument("contactId") { type = NavType.IntType })
            ) { backStackEntry ->
                val contactId = backStackEntry.arguments?.getInt("contactId")
                ContactFormScreen(navController, contactId)
            }
        }
    }
}
