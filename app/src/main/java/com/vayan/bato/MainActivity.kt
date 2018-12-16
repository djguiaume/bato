package com.vayan.bato

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.vayan.bato.features.listcameras.ListCamerasFragment
import com.vayan.bato.utils.isPermissionGranted

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), PERMISSIONS_REQUEST_CAMERA)
        } else {
            if (savedInstanceState == null) {
                navigateToCameraListing()
            }
        }
    }

    private fun navigateToCameraListing() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, ListCamerasFragment())
            .commit()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_CAMERA -> {
                if (grantResults.isPermissionGranted()) {
                    navigateToCameraListing()
                }
            }
            else -> {
                // Ignore all other requests
            }
        }
    }

    companion object {
        const val PERMISSIONS_REQUEST_CAMERA = 11
    }
}
