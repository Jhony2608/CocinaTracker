package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEntregasBinding
import com.example.myapplication.model.DashboardAction
import com.example.myapplication.ui.adapter.DashboardActionAdapter

/**
 * Fragment de la pantalla del módulo de Entregas (APPCC).
 * Gestiona la cuadrícula de acciones rápidas y la navegación hacia la pantalla de Nueva Entrega.
 */
class EntregasFragment : Fragment() {

    private var _binding: FragmentEntregasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntregasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDashboardGrid()
    }

    private fun setupDashboardGrid() {
        // Cuadrícula de 3 columnas para Tablet Landscape
        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvMainDashboard.layoutManager = gridLayoutManager

        // Lista de acciones rápidas
        val mockActions = listOf(
            DashboardAction(
                id = 1,
                title = "Nueva Entrega",
                iconResId = android.R.drawable.ic_menu_add
            ),
            DashboardAction(
                id = 2,
                title = "Historial de Albaranes",
                iconResId = android.R.drawable.ic_menu_agenda
            ),
            DashboardAction(
                id = 3,
                title = "Directorio de Proveedores",
                iconResId = android.R.drawable.ic_menu_myplaces
            )
        )

        // Adaptador con navegación condicional por id de acción
        val adapter = DashboardActionAdapter(mockActions) { action ->
            if (action.id == 1) {
                // Navegar a la pantalla de Registro de Nueva Entrega (Sprint 2)
                findNavController().navigate(R.id.action_entregasFragment_to_nuevaEntregaFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Acción seleccionada: ${action.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.rvMainDashboard.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
