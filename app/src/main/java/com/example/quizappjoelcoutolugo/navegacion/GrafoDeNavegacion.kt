package com.example.quizappjoelcoutolugo.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
/*import com.example.quizappjoelcoutolugo.home.PantallaPrincipal
import com.example.quizappjoelcoutolugo.modoexamen.PantallaModoExamen
import com.example.quizappjoelcoutolugo.nota.PantallaMensajeNota
import com.example.quizappjoelcoutolugo.modonormal.PantallaModoNormal*/
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.pantallas.*

@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaPrincipal.ruta) {


        composable(Rutas.PantallaPrincipal.ruta){
            PantallaPrincipal(navController = navController)
        }

        composable(Rutas.PantallaModoNormal.ruta){
            PantallaModoNormal(navController = navController)
        }
        composable(Rutas.PantallaModoExamen.ruta){
            PantallaModoExamen(navController = navController)
        }
        composable(Rutas.PantallaMensajeNota.ruta + "/{aciertos}") { llamada ->
            val aciertos = llamada.arguments?.getString("aciertos")
            if (aciertos != null) {
                PantallaMensajeNota(aciertos = aciertos.toInt(), navController = navController)
            }
        }
    }
}