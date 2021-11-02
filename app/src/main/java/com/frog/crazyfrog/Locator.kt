package com.frog.crazyfrog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.frog.crazyfrog.databinding.ActivityLocatorBinding
import kotlin.random.Random

class Locator : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLocatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val location : location = getFrogLocation()
        mMap.addMarker(MarkerOptions().position(location.locationCoords).title(getString(R.string.location_preposition) + " " + location.locationName))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location.locationCoords))
    }

    private fun getFrogLocation(): location {
        val newYork = location(getString(R.string.city_one), LatLng(40.71, 74.0))
        val london = location(getString(R.string.city_two), LatLng(51.50, 0.1))
        val kortrijk = location(getString(R.string.city_three), LatLng(50.81, 3.25))
        val bruges = location(getString(R.string.city_four), LatLng(51.20, 3.22))
        val vichte = location(getString(R.string.city_five), LatLng(50.8379, 3.4030))

        val locationList = arrayOf(
            newYork,
            london,
            kortrijk,
            bruges,
            vichte
        )
        val placeIndex = Random.nextInt(1, 5)
        return locationList[placeIndex]
    }


    class location (name : String, location : LatLng){
        val locationName = name
        val locationCoords = location
    }
}