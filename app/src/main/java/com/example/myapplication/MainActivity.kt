package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

/**
 * Pantalla principal del sistema de Seguridad Alimentaria (APPCC) para Tablet en Horizontal.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationListeners()
    }

    private fun setupNavigationListeners() {
        binding.btnNavDeliveries.setOnClickListener {
            Toast.makeText(this, getString(R.string.nav_deliveries), Toast.LENGTH_SHORT).show()
        }

        binding.btnNavTemperatures.setOnClickListener {
            Toast.makeText(this, getString(R.string.nav_temperatures), Toast.LENGTH_SHORT).show()
        }

        binding.btnNavSettings.setOnClickListener {
            Toast.makeText(this, getString(R.string.nav_settings), Toast.LENGTH_SHORT).show()
        }
    }
}