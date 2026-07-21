package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentEntregasBinding

/**
 * Fragment de la pantalla por defecto del módulo de Entregas y Recepción de Mercancías (APPCC).
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
        // El RecyclerView rv_main_dashboard se configurará aquí con un GridLayoutManager en el futuro.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
