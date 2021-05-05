package com.signaturepadkotlin

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.github.gcacace.signaturepad.views.SignaturePad
import com.signaturepadkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize(): Unit {

        binding.signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {

            }

            override fun onClear() {
            }

            override fun onSigned() {

            }

        })

        binding.clearButton.setOnClickListener() {
            binding.signaturePad.clear()
            binding.ivSignature.setImageResource(0)
        }

        binding.saveButton.setOnClickListener() {

            binding.ivSignature.setImageResource(0)
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                binding.ivSignature.setImageBitmap(binding.signaturePad.signatureBitmap)
            }, 500)
        }

    }
}