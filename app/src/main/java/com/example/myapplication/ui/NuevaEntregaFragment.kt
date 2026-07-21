package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNuevaEntregaBinding

/**
 * Fragment para el registro de una Nueva Entrega de mercancías (APPCC).
 * Formulario adaptado 50%/50% para Tablets en modo Landscape.
 */
class NuevaEntregaFragment : Fragment() {

    private var _binding: FragmentNuevaEntregaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNuevaEntregaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        // Listener para la captura de fotografía del albarán
        binding.btnTakePhoto.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Iniciando cámara para fotografiar albarán...",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Listener para guardar la entrega
        binding.btnSaveDelivery.setOnClickListener {
            val supplier = binding.etSupplier.text.toString().trim()
            val product = binding.etProduct.text.toString().trim()

            if (supplier.isEmpty() || product.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Complete los campos obligatorios: Proveedor y Producto",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Entrega registrada con éxito ($supplier - $product)",
                    Toast.LENGTH_LONG
                ).show()
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
