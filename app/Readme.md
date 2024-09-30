# LineaIII-Agenda_Contactos

## Descripción
**LineaIII-Agenda_Contactos**
- Es una aplicación de gestión de contactos desarrollada en Android Studio.
- Por el estudiante Cain David Martinez del núcleo temático de Lína de profundización III 901N
- Permite a los usuarios agregar, editar y listar sus contactos en una interfaz intuitiva y fácil de usar.

## Funcionalidades Principales

### MainActivity.kt
- **Punto de Entrada**: La actividad principal inicializa la interfaz de usuario con un tema personalizado.
- **Navegación**: Usa `NavigationExample` para manejar la navegación entre diferentes pantallas de la aplicación.

### Navegación.kt
- **Controlador de Navegación**: Configura un `NavHost` que permite la navegación entre la lista de contactos y el formulario para agregar/editar contactos.
- **Pantallas**:
    - **Lista de Contactos**: Pantalla inicial que muestra todos los contactos.
    - **Formulario de Contacto**: Permite añadir un nuevo contacto o editar uno existente.

### ContactoFormPantalla.kt
- **Modelo de Contacto**: Define la clase `Contact`, que incluye campos como ID, nombre, apellido, teléfono y hobby.
- **Formulario**: Incluye campos de entrada para los detalles del contacto y un botón para guardar los cambios.

### ContactoListaPantalla.kt
- **Lista de Contactos**: Muestra todos los contactos en una lista, con opciones para editar o eliminar cada uno.
- **Tarjeta de Contacto**: Presenta los detalles del contacto y botones de acción.

### BottonNavigationBar.kt
- **Barra de Navegación Inferior**: Proporciona acceso rápido a las dos pantallas principales: añadir contacto y lista de contactos.
- **Elementos de Navegación**: Incluye iconos y etiquetas para cada sección de la aplicación.

## IDE y Lenguaje utilizados
- Android Studio
- Kotlin

---

¡Disfruta gestionando tus contactos con esta app!