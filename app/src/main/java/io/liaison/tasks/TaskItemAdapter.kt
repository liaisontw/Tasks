package io.liaison.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
//import android.widget.ListAdapter
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import io.liaison.tasks.databinding.TaskItemBinding
//import io.liaison.tasks.generated.callback.OnClickListener

//class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
class TaskItemAdapter(val clickListener: (taskId: Long) -> Unit)
    : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()) {
/*
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size
*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        //val item = data[position]
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class TaskItemViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        //val taskName = rootView.findViewById<TextView>(R.id.task_name)
        //val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)
        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                //val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task, clickListener: (taskId: Long) -> Unit) {
            //taskName.text = item.taskName
            //taskDone.isChecked = item.taskDone
            binding.task = item
            binding.root.setOnClickListener { clickListener(item.taskId) }
        }
    }
}