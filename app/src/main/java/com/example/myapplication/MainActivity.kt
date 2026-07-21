package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.databinding.ActivityMainBinding

/**
 * Pantalla principal del sistema de Seguridad Alimentaria (APPCC) para Tablet en Horizontal.
 * Gestiona la navegación mediante Jetpack Navigation y los botones del menú lateral.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationController()
        setupNavigationListeners()
    }

    private fun setupNavigationController() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            updateSidebarButtonState(destination.id)
        }
    }

    private fun setupNavigationListeners() {
        binding.btnNavDeliveries.setOnClickListener {
            if (navController.currentDestination?.id != R.id.entregasFragment) {
                navController.navigate(R.id.entregasFragment)
            }
        }

        binding.btnNavTemperatures.setOnClickListener {
            if (navController.currentDestination?.id != R.id.temperaturasFragment) {
                navController.navigate(R.id.temperaturasFragment)
            }
        }

        binding.btnNavSettings.setOnClickListener {
            if (navController.currentDestination?.id != R.id.ajustesFragment) {
                navController.navigate(R.id.ajustesFragment)
            }
        }
    }

    private fun updateSidebarButtonState(destinationId: Int) {
        // Entregas
        val isEntregas = destinationId == R.id.entregasFragment
        binding.btnNavDeliveries.apply {
            backgroundTintList = getColorStateList(
                if (isEntregas) R.color.primary_blue else android.R.color.transparent
            )
            setTextColor(getColor(if (isEntregas) R.color.text_on_primary else R.color.text_primary))
            strokeWidth = if (isEntregas) 0 else 2
        }

        // Temperaturas
        val isTemperaturas = destinationId == R.id.temperaturasFragment
        binding.btnNavTemperatures.apply {
            backgroundTintList = getColorStateList(
                if (isTemperaturas) R.color.primary_blue else android.R.color.transparent
            )
            setTextColor(getColor(if (isTemperaturas) R.color.text_on_primary else R.color.text_primary))
            strokeWidth = if (isTemperaturas) 0 else 2
        }

        // Ajustes
        val isAjustes = destinationId == R.id.ajustesFragment
        binding.btnNavSettings.apply {
            backgroundTintList = getColorStateList(
                if (isAjustes) R.color.primary_blue else android.R.color.transparent
            )
            setTextColor(getColor(if (isAjustes) R.color.text_on_primary else R.color.text_primary))
            strokeWidth = if (isAjustes) 0 else 2
        }
    }
}