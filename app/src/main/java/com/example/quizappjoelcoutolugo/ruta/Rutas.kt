package com.example.quizappjoelcoutolugo.ruta

sealed class Rutas(val ruta: String) {

    object HomeView: Rutas("homeview")
    object EasyModeView: Rutas("easymodeview")
    object ExamenView: Rutas("examenView")
    object ResultadosView: Rutas("resultadosview")
}