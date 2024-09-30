package com.example.agendac.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Lista de contactos que puede ser modificada en diferentes pantallas
val contacts = mutableStateListOf<Contact>()

/**
 * Clase de datos que representa un contacto.
 * Cada contacto tiene un ID, nombre, apellido, teléfono y hobby.
 *
 * @param id Identificador único del contacto.
 * @param name Nombre del contacto.
 * @param surname Apellido del contacto.
 * @param phone Número de teléfono del contacto.
 * @param hobby Pasatiempo favorito del contacto.
 */
data class Contact(
    val id: Int,
    val name: String,
    val surname: String,
    val phone: String,
    val hobby: String
)

/**
 * Pantalla que muestra el formulario para agregar o editar un contacto.
 * Si se recibe un contactId, la pantalla se comporta como un formulario de edición,
 * de lo contrario, se comporta como un formulario para agregar un nuevo contacto.
 *
 * @param navController Controlador de navegación para cambiar entre pantallas.
 * @param contactId El ID del contacto a editar, si es nulo, es un nuevo contacto.
 */
@Composable
fun ContactFormScreen(navController: NavController, contactId: Int? = null) {
    // Si contactId no es nulo, busca el contacto existente que se va a editar.
    val contact = contacts.find { it.id == contactId }

    // Variables que almacenan el estado actual de los campos del formulario.
    // Si se está editando un contacto existente, se inicializan con sus valores.
    var name by remember { mutableStateOf(contact?.name ?: "") }
    var surname by remember { mutableStateOf(contact?.surname ?: "") }
    var phone by remember { mutableStateOf(contact?.phone ?: "") }
    var hobby by remember { mutableStateOf(contact?.hobby ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Añade un margen alrededor del contenido
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        // Campo de texto para el nombre
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") } // Etiqueta del campo de texto
        )
        Spacer(modifier = Modifier.height(8.dp)) // Añade espacio entre los campos

        // Campo de texto para el apellido
        TextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text("Apellido") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto para el teléfono
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto para el hobby
        TextField(
            value = hobby,
            onValueChange = { hobby = it },
            label = { Text("Hobby") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar o agregar un nuevo contacto
        Button(onClick = {
            if (contactId != null) {
                // Si es una edición, actualizamos el contacto existente
                val editedContact = Contact(contactId, name, surname, phone, hobby)
                val index = contacts.indexOfFirst { it.id == contactId }
                if (index >= 0) {
                    contacts[index] = editedContact // Reemplaza el contacto editado
                }
            } else {
                // Si es un nuevo contacto, lo añadimos a la lista de contactos
                val newContact = Contact(
                    id = contacts.size + 1, // Genera un nuevo ID
                    name = name,
                    surname = surname,
                    phone = phone,
                    hobby = hobby
                )
                contacts.add(newContact) // Añade el nuevo contacto
            }
            // Navega de vuelta a la lista de contactos después de agregar/editar
            navController.navigate("list")
        }) {
            // Cambia el texto del botón según si estamos añadiendo o editando un contacto
            Text(text = if (contactId != null) "Guardar Cambios" else "Agregar Contacto")
        }
    }
}

