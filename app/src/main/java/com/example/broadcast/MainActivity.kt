package com.example.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcast.databinding.ActivityMainBinding

/*Android companenta
* 1->activity
* 2->broadcast resiver
* 3->provaider va servislari*/
/*Ui companenta*/
/*broadcast resiver->Bu tizim yoki dastur event lariga royxatdan otishga imakon
* beruvchi android companenta hisoblanadi.event sodir bolgandan keyin
* barcha royxatdan otgan qabul qiluvchilarga android system tomonidan xabar qilinadi*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myGpsBroadcast = MyGpsBroadcast()
        val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        filter.addAction(Intent.ACTION_PROVIDER_CHANGED)

        this.registerReceiver(myGpsBroadcast, filter)
    }
}