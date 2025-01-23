package com.example.screennavigation.components

import com.example.screennavigation.data.Student

interface Repository {
    fun getStudent(rollNo: Int): Student
    fun setStudent(student: Student)
}

/*
The repository pattern in Kotlin, when used with IntelliJ IDEA,
 provides a structured way to manage data access,
 making your code cleaner, more modular, and easier to test.
  It's a widely used design pattern in modern software development,
  especially in applications that require a clear separation between the data layer and the business logic.
 */