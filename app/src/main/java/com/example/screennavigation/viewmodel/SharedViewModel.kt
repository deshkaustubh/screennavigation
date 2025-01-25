package com.example.screennavigation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.screennavigation.components.AppRepository
import com.example.screennavigation.data.Student

class SharedViewModel(repository: AppRepository): ViewModel() {
    val student  = MutableLiveData<Student>()

    //Store roll Number
    val rollNo = MutableLiveData<Int>()

    private val repository by lazy {repository}

    fun getStudent(): Student {
        return repository.getStudent(rollNo = rollNo.value ?: 0)
    }

    fun setStudent(student: Student) {
        repository.setStudent(student = student)
    }

}