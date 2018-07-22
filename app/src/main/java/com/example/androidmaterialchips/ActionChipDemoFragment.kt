package com.example.androidmaterialchips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_action_chip_demo.view.*


class ActionChipDemoFragment : Fragment() {
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_action_chip_demo, container, false)

        mView.turnLightsOnChip.setOnClickListener { Toast.makeText(context, "Lights are turned on", Toast.LENGTH_SHORT).show() }
        mView.setAlarmChip.setOnClickListener { Toast.makeText(context, "Alarm is set", Toast.LENGTH_SHORT).show() }
        mView.playMusicChip.setOnClickListener { Toast.makeText(context, "Playing some music", Toast.LENGTH_SHORT).show() }

        return mView
    }

    companion object {
        @JvmStatic
        fun newInstance() = ActionChipDemoFragment()
    }
}
