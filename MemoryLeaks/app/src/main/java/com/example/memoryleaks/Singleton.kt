package com.example.memoryleaks

import android.content.Context

class Singleton private constructor(private val context: Context) {
    companion object {

        private var singleton: Singleton? = null

        @Synchronized
        fun getInstance(context: Context): Singleton {
            if (singleton == null) {
                /**
                 * Salvar apenas o context é um problema, porque teremos salvo
                 * a activity mesmo após ela ser encerrada. O ideal é utilizar o context
                 * da aplicação com context.applicationContext()
                 */
                singleton = Singleton(context)
            }

            return singleton as Singleton
        }
    }

}