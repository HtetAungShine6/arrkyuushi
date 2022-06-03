package com.example.zlhhapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_todo_list_item.view.*

class ResultTextAdapter
    (private val resultText: MutableList<String>, private val listener: AdapterListener) : RecyclerView.Adapter<TodoListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_todo_list_item, parent, false)
        return TodoListItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        val item = resultText[position]
        holder.itemView.tvResult.text = item
        holder.itemView.btnDelete.setOnClickListener {
            listener.passData(item)
            resultText.remove(item)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return resultText.size
    }
}

class TodoListItemViewHolder(itemView: View, private val listener: AdapterListener) :
    RecyclerView.ViewHolder(itemView.rootView) {

}

