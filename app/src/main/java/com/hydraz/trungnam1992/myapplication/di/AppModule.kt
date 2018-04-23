package com.hydraz.trungnam1992.myapplication.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by trungnam1992 on 4/24/18.
 */
@Module
class AppModule {

    lateinit var mApplication : Application
    fun AppModule(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    internal fun provideApplication(appModule: AppModule): Application {
        return appModule.mApplication
    }

    @Provides
    @Singleton
    fun providerCompositeDisposable(): CompositeDisposable {
        val compositeDisposable = CompositeDisposable()
        return compositeDisposable
    }

}