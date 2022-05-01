package com.denis.recipebookandroid.model.app

import android.app.Application
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.dao.data_base.AppRecipeDataBase
import com.denis.recipebookandroid.model.dao.db_instances.RecipeDBInstance
import com.denis.recipebookandroid.model.repositories.LoggedInUserRepository
import com.denis.recipebookandroid.model.repositories.RecipeCreateRepository
import com.denis.recipebookandroid.model.repositories.SignInUpRepository
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.view.ui.create_recipe.RecipeCreateViewModel
import com.denis.recipebookandroid.view.ui.login.LoginViewModel
import com.denis.recipebookandroid.view.ui.registration.RegistrationViewModel
import com.denis.recipebookandroid.view.ui.user_main.UserMainViewModel
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MyApp)

            modules(appModule, dbModule, networkModule)
        }
    }

    private val appModule = module {
        single { SignInUpRepository(get()) }
        single { UserMainRepository(get(), get()) }
        single { RecipeCreateRepository(get()) }
        single { LoggedInUserRepository() }

        viewModel { UserMainViewModel(get()) }
        viewModel { LoginViewModel(get()) }
        viewModel { RegistrationViewModel(get()) }
        viewModel { RecipeCreateViewModel(get()) }

    }

    private val dbModule = module {
        single { RecipeDBInstance(this@MyApp).getRecipeDataBase() }
        single { get<AppRecipeDataBase>().getRecipeEntityDao() }
    }

    private val networkModule = module {
        single { GsonBuilder().setLenient().create() }
        single { RetrofitInstance.getRetrofitInstance() }
        single { RetrofitInstance.getLoginServiceInstance() }
    }
}