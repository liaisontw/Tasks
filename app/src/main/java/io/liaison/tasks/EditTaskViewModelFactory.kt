package io.liaison.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.liaison.tasks.TaskDao

class EditTaskViewModelFactory(private val taskId: Long,
                                private val dao: TaskDao)
    : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((EditTaskViewModel::class.java))) {
            return EditTaskViewModel(taskId, dao) as T
        }
        throw IllegalAccessException("Unknown ViewModel")
    }
}