package com.denis.recipebookandroid.model.app

import android.app.Application
import com.denis.recipebookandroid.model.api.api_datasources.*
import com.denis.recipebookandroid.model.api.retrofits.RetrofitInstance
import com.denis.recipebookandroid.model.dao.data_base.AppRecipeDataBase
import com.denis.recipebookandroid.model.dao.db_datasources.RecipeDbDataSource
import com.denis.recipebookandroid.model.dao.db_instances.RecipeDBInstance
import com.denis.recipebookandroid.model.repositories.LoggedInUserRepository
import com.denis.recipebookandroid.model.repositories.RecipeCreateRepository
import com.denis.recipebookandroid.model.repositories.SignInUpRepository
import com.denis.recipebookandroid.model.repositories.UserMainRepository
import com.denis.recipebookandroid.model.repositories.interfaces.ILoggedInUserRepository
import com.denis.recipebookandroid.model.repositories.interfaces.IRecipeCreateRepository
import com.denis.recipebookandroid.model.repositories.interfaces.ISignInUpRepository
import com.denis.recipebookandroid.model.repositories.interfaces.IUserMainRepository
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

//            androidLogger(Level.INFO)
            androidContext(this@MyApp)
            modules(appModule, dbModule, networkModule)
        }
    }

    private val appModule = module {

        single<ISignInUpRepository> { SignInUpRepository(get()) }
        single<IUserMainRepository> { UserMainRepository(get(), get()) }
        single<IRecipeCreateRepository> { RecipeCreateRepository(get(), get()) }
        single<ILoggedInUserRepository> { LoggedInUserRepository() }

        viewModel { UserMainViewModel(get()) }
        viewModel { LoginViewModel(get()) }
        viewModel { RegistrationViewModel(get()) }
        viewModel { RecipeCreateViewModel(get()) }

    }

    private val dbModule = module {
        single { RecipeDBInstance(this@MyApp).getRecipeDataBase() }
        single { get<AppRecipeDataBase>().getRecipeEntityDao() }
        single {RecipeDbDataSource(get()) }

    }

    private val networkModule = module {
        single { GsonBuilder().setLenient().create() }
        single { RetrofitInstance.getRecipeRetrofitInstance() }
        single { RetrofitInstance.getLoginServiceInstance() }
        single { RetrofitInstance.getUserRetrofitInstance() }

        single<IRecipeApiDataSource> { RecipeApiDataSource(get()) }
        single<ISignInUpApiDataSource> { SignInUpApiDataSource(get()) }
        single<IUserApiDataSource> { UserApiDataSource(get()) }
    }
}