package com.example.luxury.kotlinweatherapp

import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , GoogleApiClient.ConnectionCallbacks ,GoogleApiClient.OnConnectionFailedListener,LocationListener {


    val PERMISSON_REQUEST_CODE=1001
    val PLAY_SERVICE_RESULOTION_REQUEST= 1000

    var mGoogleApiClient:GoogleApiClient?=null
    var mLocationRequest:LocationRequest?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission()
        if(checkPlayServices()) buildGoogleApiClient()
    }

    //Kiem tra cap phep permisson
    private fun requestPermission() {
        if((ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED))
        {
            //Neu chua cap phep permisson -> goi ham cap permisson
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,android.Manifest.permission.ACCESS_FINE_LOCATION),PERMISSON_REQUEST_CODE)
            }
        }
    }

    //Callback khi goi ham cap permisson
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSON_REQUEST_CODE->{
                if(grantResults.size>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    checkPlayServices()
                    buildGoogleApiClient()
                }
            }
        }
    }

    private fun buildGoogleApiClient() {
        mGoogleApiClient=GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener (this)
                .addApi(LocationServices.API)
                .build()
    }

    private fun checkPlayServices():Boolean {
        var resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this)
        if(resultCode!=ConnectionResult.SUCCESS)
        {
            if(GooglePlayServicesUtil.isUserRecoverableError(resultCode))
            {
                GooglePlayServicesUtil.getErrorDialog(resultCode,this,PLAY_SERVICE_RESULOTION_REQUEST).show()
            }
            else
            {
                Toast.makeText(applicationContext,"this device is not supported",Toast.LENGTH_SHORT).show()
            }
            return false
        }
        return true
    }

    override fun onConnectionSuspended(p0: Int) {
        mGoogleApiClient!!.connect()
    }

    override fun onConnected(p0: Bundle?) {
        createLocationRequest()
    }

    private fun createLocationRequest() {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval=10000 //10 s
        mLocationRequest!!.fastestInterval=5000 //5s
        mLocationRequest!!.priority=LocationRequest.PRIORITY_HIGH_ACCURACY
        //kiem tra permission
        if((ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED))
        {
            return
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationRequest,this)
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.i("ERROR","connection failed: "+p0.errorCode)
    }

    override fun onLocationChanged(location: Location?) {
        textView.text = "${location!!.latitude} - ${location!!.longitude}"
    }

    override fun onStart() {
        super.onStart()
        if(mGoogleApiClient!=null)
            mGoogleApiClient!!.connect()
    }

    override fun onDestroy() {
        mGoogleApiClient!!.disconnect()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        checkPlayServices()
    }
}


