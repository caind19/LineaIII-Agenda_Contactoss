/*
    Aplicación para la gestión y listado de contactos de una agenda personal.
    Cain David Martinez Cardona
    901N
*/

package com.example.agendac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.agendac.navegacion.BottomNavigationBar
import com.example.agendac.navegacion.NavigationExample
import com.example.agendac.ui.theme.AgendaCTheme

// Actividad principal de la app que amplía ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplica tema personalizado inicializando la interfaz de la app
            AgendaCTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationExample() //Composable que maneja la interfaz de varias pantallas de la app
                }
            }
        }
    }
}

