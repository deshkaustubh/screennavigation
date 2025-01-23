package com.example.screennavigation

import android.app.Application
import com.example.screennavigation.components.AppRepository
class MyApplication: Application() {
    private lateinit var repository: AppRepository

    override fun onCreate() {
        super.onCreate()
        repository = AppRepository()
    }

    fun getRepository(): AppRepository {
        return repository
    }
}