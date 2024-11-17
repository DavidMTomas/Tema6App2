package com.davidmaiques.tema6app2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.davidmaiques.tema6app2.databinding.ActivityMainBinding
import com.davidmaiques.tema6app2.fragments.BlueFragment
import com.davidmaiques.tema6app2.fragments.GreenFragment
import com.davidmaiques.tema6app2.fragments.RedFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnRojo = binding.btnRojo
        val btnAzul = binding.btnAzul
        val btnVerde = binding.btnVerde

        btnRojo.setOnClickListener {
           mostrarFragment(RedFragment())
        }
        btnVerde.setOnClickListener {
            mostrarFragment(GreenFragment())
        }
        btnAzul.setOnClickListener {
            mostrarFragment(BlueFragment())
        }

    }
    private fun mostrarFragment(fragment: Fragment) {
        val transaccion = supportFragmentManager.beginTransaction()
        transaccion.replace(R.id.fgContenedor,fragment)
        transaccion.addToBackStack(null)
        transaccion.commit()
    }
}