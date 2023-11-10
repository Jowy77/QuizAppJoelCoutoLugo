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

    NavHost(navController = navController, startDestination = Rutas.HomeView.ruta) {


        composable(Rutas.HomeView.ruta){
            HomeView(navController = navController)
        }

        composable(Rutas.EasyModeView.ruta){
            EasyModeView(navController = navController)
        }
        composable(Rutas.ExamenView.ruta){
            ExamenView(navController = navController)
        }
        composable(Rutas.ResultadosView.ruta + "/{aciertos}") { llamada ->
            val aciertos = llamada.arguments?.getString("aciertos")
            if (aciertos != null) {
                ResultadosView(aciertos = aciertos.toInt(), navController = navController)
            }
        }
    }
}