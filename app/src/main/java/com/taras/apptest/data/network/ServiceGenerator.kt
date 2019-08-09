package com.taras.apptest.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.taras.apptest.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object ServiceGenerator {

    private val httpClient: OkHttpClient.Builder
    private val builder: Retrofit.Builder

    init {
        Timber.d("[API BASE URL] %s", BuildConfig.API_BASE_URL)

        httpClient = OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                chain.proceed(requestBuilder.build())
            }
        }

        builder = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(createGsonConverterFactory())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
    }

    private fun createGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        Timber.d("Call <%s>", serviceClass.simpleName)
        val client = httpClient
            .build()
        val retrofit = builder
            .client(client)
            .build()
        return retrofit.create(serviceClass)
    }
}