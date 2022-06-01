package com.example.zlhhapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_todo_list_item.view.*

class ResultTextAdapter(
    resultText: MutableList<String>, private val listener: AdapterListener
) : RecyclerView.Adapter<TodoListItemViewHolder>() {

    private var data = resultText

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_todo_list_item, parent, false)
        return TodoListItemViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.tvResult.text = item
        holder.itemView.btnDelete.setOnClickListener {

            data.remove(item)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class TodoListItemViewHolder(itemView: View, listener: AdapterListener) :
    RecyclerView.ViewHolder(itemView) {

}

