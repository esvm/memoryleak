package com.example.memoryleaks

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class ThreadActivity : AppCompatActivity() {
//    private val thread = ExampleTask()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ExampleTask().start()
//        thread.start()
    }

    fun start(context: Context) {
        val starter = Intent(context, ThreadActivity::class.java)
        context.startActivity(starter)
    }

//    @Override
//    fun onDestroy(context: Context) {
//        onDestroy(context)
//
//        thread.interrupt()
//    }

    /**
     * um outro memory leak é criar threads dentro da activity.
     * isso porque se o telefone for rotacionado ou por algum motivo a activity
     * for finalizada, a thread vai continuar rodando em background porque ela não vai ter seu
     * processo encerrado, o que vai ocasionar num leak que o GC não vai conseguir reconhecer
     */
    private inner class ExampleTask : Thread() {
        override fun run() {
//            while (!isInterrupted)
                SystemClock.sleep((2000 * 10).toLong())
        }
    }
}