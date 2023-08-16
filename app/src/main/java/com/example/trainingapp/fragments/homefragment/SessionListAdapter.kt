package com.example.trainingapp.fragments.homefragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingapp.data.database.tables.session_table.SessionTable
import com.example.trainingapp.databinding.HomeItemBinding


class SessionListAdapter(private val onItemClicked: (SessionTable) -> Unit) : ListAdapter<SessionTable, SessionListAdapter.ProgramViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<SessionTable>() {
        override fun areItemsTheSame(oldItem: SessionTable, newItem: SessionTable):
                Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SessionTable, newItem:
        SessionTable
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class ProgramViewHolder(private var binding:HomeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SessionTable) {
            binding.session = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ProgramViewHolder {
        return ProgramViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder:
                                  ProgramViewHolder, position: Int) {
        val program = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(program)
        }
        holder.bind(program)
    }
}