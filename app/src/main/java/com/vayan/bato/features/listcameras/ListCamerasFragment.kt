package com.vayan.bato.features.listcameras

import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vayan.bato.R
import kotlinx.android.synthetic.main.fragment_list_cameras.*

class ListCamerasFragment : Fragment() {
    private lateinit var cameraAdapter: RecyclerView.Adapter<*>
    private lateinit var cameraManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_cameras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let { context ->
            val cameraList = ContextCompat.getSystemService(
                context,
                CameraManager::class.java
            )?.let { cameraManager ->
                cameraManager.cameraIdList.map { cameraId ->
                    cameraManager.getCameraCharacteristics(cameraId)
                }
            } ?: listOf()

            cameraAdapter = CamerasAdapter(cameraList)
            cameraManager = LinearLayoutManager(context)

            cameras_list.apply {
                setHasFixedSize(true)
                layoutManager = cameraManager
                adapter = cameraAdapter
            }
        }
    }
}
