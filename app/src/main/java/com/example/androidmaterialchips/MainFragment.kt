package com.example.androidmaterialchips

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {
    private var listener: MainFragment.OnFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.entry_button.setOnClickListener {
            onEntryButtonPressed()
        }

        view.choice_button.setOnClickListener {
            onChoiceButtonPressed()
        }

        view.filter_button.setOnClickListener {
            onFilterButtonPressed()
        }

        view.action_button.setOnClickListener {
            onActionButtonPressed()
        }

        // Inflate the layout for this fragment
        return view
    }

    fun onEntryButtonPressed() {
        listener?.onFragmentInteractionEntryButtonPressed()
    }

    fun onChoiceButtonPressed() {
        listener?.onFragmentInteractionChoiceButtonPressed()
    }

    fun onFilterButtonPressed() {
        listener?.onFragmentInteractionFilterButtonPressed()
    }

    fun onActionButtonPressed() {
        listener?.onFragmentInteractionActionButtonPressed()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteractionEntryButtonPressed()
        fun onFragmentInteractionChoiceButtonPressed()
        fun onFragmentInteractionFilterButtonPressed()
        fun onFragmentInteractionActionButtonPressed()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
