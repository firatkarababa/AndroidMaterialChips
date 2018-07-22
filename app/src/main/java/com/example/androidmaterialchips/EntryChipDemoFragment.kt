package com.example.androidmaterialchips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_entry_chip_demo.view.*
import com.example.androidmaterialchips.R.drawable.baseline_person_black_18
import com.google.android.material.chip.ChipGroup


class EntryChipDemoFragment : Fragment() {
    private val PEOPLE = arrayOf("John Smith", "Kate Eckhart", "Emily Sun", "Frodo Baggins")
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_entry_chip_demo, container, false)

        val adapter = ArrayAdapter<String>(activity,
                android.R.layout.simple_dropdown_item_1line, PEOPLE)

        mView.autoCompleteTextView.setAdapter<ArrayAdapter<String>>(adapter)
        mView.autoCompleteTextView.setOnItemClickListener { parent, arg1, position, arg3 ->
            mView.autoCompleteTextView.text = null
            val selected = parent.getItemAtPosition(position) as String
            addChipToGroup(selected, mView.chipGroup2)
        }

        return mView
    }


    private fun addChipToGroup(person: String, chipGroup: ChipGroup) {
        val chip = Chip(context)
        chip.text = person
        chip.chipIcon = ContextCompat.getDrawable(requireContext(), baseline_person_black_18)
        chip.isCloseIconEnabled = true
        chip.setChipIconTintResource(R.color.chipIconTint)

        // necessary to get single selection working
        chip.isClickable = true
        chip.isCheckable = false
        chipGroup.addView(chip as View)
        chip.setOnCloseIconClickListener { chipGroup.removeView(chip as View) }
    }

    companion object {
        @JvmStatic
        fun newInstance() = EntryChipDemoFragment()
    }
}
