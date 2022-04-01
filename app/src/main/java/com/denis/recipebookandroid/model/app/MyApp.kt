package com.denis.recipebookandroid.model.app

import android.app.Application
import com.denis.recipebookandroid.model.repositories.ISignInUpRepository
import com.denis.recipebookandroid.model.repositories.IUserMainRepository
import com.denis.recipebookandroid.model.repositories.SignInUpRepository
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.view.ui.login.LoginViewModel
import com.denis.recipebookandroid.view.ui.user_main.UserMainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }

    }

    private val appModule = module{

        single<IUserMainRepository> { UserMainRepository(this@MyApp) }
        single<ISignInUpRepository>{ SignInUpRepository()}
        viewModel { UserMainViewModel(get())}
        viewModel { LoginViewModel(get()) }

    }

}