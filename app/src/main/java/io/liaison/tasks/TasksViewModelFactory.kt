package io.liaison.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TasksViewModelFactory(private val dao: TaskDao)
                            : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
   override fun <T: ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom((TaskViewModel::class.java))) {
           return TaskViewModel(dao) as T
       }
       throw IllegalAccessException("Unknown ViewModel")
   }
}