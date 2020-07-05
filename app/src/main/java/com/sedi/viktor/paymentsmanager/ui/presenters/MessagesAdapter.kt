package com.sedi.viktor.paymentsmanager.ui.presenters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.sedi.viktor.paymentsmanager.databinding.MessageItemBinding
import java.util.zip.Inflater

class MessagesAdapter(var messages: MutableList<String>) :
    RecyclerView.Adapter<MessagesAdapter.MessageHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: MessageItemBinding = MessageItemBinding.inflate(inflater, parent, false)
        return MessageHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        var message = messages[position]
        holder.bind(message)
    }

    inner class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: MessageItemBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        public fun bind(message: String) {
            binding?.setVariable(BR.message, message)
            binding?.executePendingBindings()
        }
    }

}