package com.example.data.di

import okhttp3.Interceptor
import okhttp3.Response

class RawResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // Realiza la petición y obtiene la respuesta
        val response = chain.proceed(request)
        // Lee el cuerpo de la respuesta sin consumirlo completamente
        val rawBody = response.peekBody(Long.MAX_VALUE).string()
        println("JSON devuelto: $rawBody")
        return response
    }
}
