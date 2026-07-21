package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDashboardActionBinding
import com.example.myapplication.model.DashboardAction

/**
 * Adaptador para renderizar las tarjetas de acciones rápidas en la cuadrícula (Grid) del Dashboard.
 */
class DashboardActionAdapter(
    private val actions: List<DashboardAction>,
    private val onItemClick: (DashboardAction) -> Unit
) : RecyclerView.Adapter<DashboardActionAdapter.ActionViewHolder>() {

    inner class ActionViewHolder(private val binding: ItemDashboardActionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(action: DashboardAction) {
            binding.tvActionTitle.text = action.title
            binding.ivActionIcon.setImageResource(action.iconResId)
            binding.root.setOnClickListener {
                onItemClick(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        val binding = ItemDashboardActionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ActionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        holder.bind(actions[position])
    }

    override fun getItemCount(): Int = actions.size
}
