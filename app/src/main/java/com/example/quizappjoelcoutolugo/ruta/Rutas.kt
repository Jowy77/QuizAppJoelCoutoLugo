package com.example.quizappjoelcoutolugo.ruta

sealed class Rutas(val ruta: String) {

    object PantallaPrincipal: Rutas("pantallaprincipal")
    object PantallaModoNormal: Rutas("pantallamodonormal")
    object PantallaModoExamen: Rutas("pantallamodoexamen")
    object PantallaEstadisticas: Rutas("pantallaestadisticas")
    object PantallaMensajeNota: Rutas("pantallamensajenota")
}