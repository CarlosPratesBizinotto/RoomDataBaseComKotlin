package com.prates.roomdatabasecomkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.prates.roomdatabasecomkotlin.database.AppDatabase
import com.prates.roomdatabasecomkotlin.database.daos.UserDao
import com.prates.roomdatabasecomkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)

        this.userDao = this.database.userDao()

    }

    override fun onStart() {
        super.onStart()

        loadTotalUser()

        this.binding.btnNewUser.setOnClickListener {
            openNewUserActivity()
        }


    }

    private fun openNewUserActivity() {
        startActivity(Intent(this,NewUserActivity::class.java))

    }

    private fun loadTotalUser() {

        this.binding.tvInfoTotalUser.text = "Carregando..."

        CoroutineScope(Dispatchers.IO).launch {
            val total = userDao.getTotalItens()

            withContext(Dispatchers.Main){
                binding.tvInfoTotalUser.text = "Total de usuários: $total"
            }
        }



    }

}