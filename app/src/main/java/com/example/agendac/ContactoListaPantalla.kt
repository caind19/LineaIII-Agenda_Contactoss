package com.example.agendac.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * Pantalla que muestra la lista de todos los contactos.
 * Utiliza la lista global de contactos definida en ContactFormPantalla.kt.
 *
 * @param navController Controlador de navegación para cambiar a otras pantallas.
 */
@Composable
fun ContactListScreen(navController: NavController) {
    // Obtenemos la lista de contactos global
    val contactList = contacts

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Margen de 16dp
        verticalArrangement = Arrangement.Top, // Coloca los elementos en la parte superior
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos
    ) {
        // Título de la pantalla
        Text(
            text = "Lista de Contactos",
            fontSize = 24.sp // Tamaño de la fuente
        )
        Spacer(modifier = Modifier.height(24.dp)) // Espacio entre el título y la lista

        // LazyColumn permite manejar grandes listas de manera eficiente
        LazyColumn(
            modifier = Modifier.fillMaxSize(), // Llena todo el espacio disponible
            contentPadding = PaddingValues(16.dp), // Relleno alrededor de los elementos
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espaciado entre elementos
        ) {
            // Para cada contacto en la lista, mostramos una tarjeta de contacto
            items(contactList) { contact ->
                ContactCard(contact, navController) { removedContact ->
                    contacts.remove(removedContact) // Eliminamos el contacto seleccionado
                }
            }
        }
    }
}

/**
 * Composable que muestra una tarjeta con la información de un contacto.
 * Incluye botones para editar y eliminar el contacto.
 *
 * @param contact Objeto Contact que contiene los datos del contacto.
 * @param navController Controlador de navegación para cambiar a la pantalla de edición.
 * @param onDelete Función que se ejecuta cuando el contacto es eliminado.
 */
@Composable
fun ContactCard(contact: Contact, navController: NavController, onDelete: (Contact) -> Unit) {
    // Tarjeta que envuelve los datos del contacto
    Card(
        modifier = Modifier
            .fillMaxWidth() // La tarjeta ocupa todo el ancho disponible
            .padding(8.dp) // Margen alrededor de la tarjeta
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Margen interno dentro de la tarjeta
        ) {
            // Muestra los detalles del contacto
            Text(text = "Nombre: ${contact.name} ${contact.surname}")
            Text(text = "Teléfono: ${contact.phone}")
            Text(text = "Hobby: ${contact.hobby}")

            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre los textos y los botones

            // Botón para editar el contacto
            Button(onClick = {
                navController.navigate("form/${contact.id}") // Navegamos a la pantalla de edición
            }) {
                Text(text = "Editar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botón para eliminar el contacto
            Button(onClick = {
                onDelete(contact) // Llama a la función para eliminar el contacto
            }) {
                Text(text = "Eliminar")
            }
        }
    }
}

