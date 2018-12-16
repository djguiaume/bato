package com.vayan.bato.utils

import android.content.pm.PackageManager


fun IntArray.isPermissionGranted() : Boolean = this.isNotEmpty() && this[0] == PackageManager.PERMISSION_GRANTED
