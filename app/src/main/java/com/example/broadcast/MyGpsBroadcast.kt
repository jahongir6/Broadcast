package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.Toast

private const val TAG = "MyGpsBroadcast"

class MyGpsBroadcast : BroadcastReceiver() {

    //jarayon sodir bolganda ishledi
    override fun onReceive(context: Context, intent: Intent) {
        if (LocationManager.PROVIDERS_CHANGED_ACTION.equals(intent.action)) {
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled =
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (isGpsEnabled || isNetworkEnabled) {
                Log.d(TAG, "onReceive: gps yondi")
            } else {
                Log.d(TAG, "onReceive: gps ochdi")
            }
        }
    }
}