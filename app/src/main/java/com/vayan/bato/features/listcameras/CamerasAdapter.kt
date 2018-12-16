package com.vayan.bato.features.listcameras

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraMetadata
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vayan.bato.R
import kotlinx.android.synthetic.main.list_camera_item.view.*

class CamerasAdapter(private val cameras: List<CameraCharacteristics>) :
    RecyclerView.Adapter<CamerasAdapter.CameraViewHolder>() {
    class CameraViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.list_camera_item,
            parent,
            false
        ) as ConstraintLayout

        return CameraViewHolder(layout)
    }

    override fun getItemCount() = cameras.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.layout.camera_name.text = cameras[position].toHuman()
    }
}

fun CameraCharacteristics.toHuman(): String {
    var cameraType = when (get(CameraCharacteristics.LENS_FACING)) {
        CameraMetadata.LENS_FACING_FRONT -> "Front"
        CameraMetadata.LENS_FACING_BACK -> "Back"
        CameraMetadata.LENS_FACING_EXTERNAL -> "External"
        else -> "Unknown Type"
    }

    get(CameraCharacteristics.INFO_VERSION)?.let {
        cameraType += "($it)"
    }

    return cameraType
}
