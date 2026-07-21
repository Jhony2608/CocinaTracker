package com.example.myapplication.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNuevaEntregaBinding

/**
 * Fragment para el registro de una Nueva Entrega de mercancías (APPCC).
 * Formulario adaptado 50%/50% para Tablets en modo Landscape.
 * Incluye captura de fotografía del albarán mediante la cámara nativa del sistema.
 */
class NuevaEntregaFragment : Fragment() {

    private var _binding: FragmentNuevaEntregaBinding? = null
    private val binding get() = _binding!!

    // ActivityResultLauncher para solicitar la captura de vista previa de imagen desde la cámara nativa
    private val takePictureLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        if (bitmap != null) {
            // Asignar el Bitmap capturado al ImageView
            binding.ivDeliveryPhotoPlaceholder.setImageBitmap(bitmap)
            // Ajustar el tipo de escala a CENTER_CROP para llenar el espacio sin deformarse
            binding.ivDeliveryPhotoPlaceholder.scaleType = ImageView.ScaleType.CENTER_CROP
            // Eliminar el tinte gris del icono placeholder original
            binding.ivDeliveryPhotoPlaceholder.imageTintList = null
            // Eliminar el padding interno para mostrar la imagen completa
            binding.ivDeliveryPhotoPlaceholder.setPadding(0, 0, 0, 0)
        } else {
            Toast.makeText(
                requireContext(),
                "No se capturó ninguna imagen del albarán",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

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
        // Listener del botón para lanzar el Intent de la cámara nativa
        binding.btnTakePhoto.setOnClickListener {
            takePictureLauncher.launch(null)
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
