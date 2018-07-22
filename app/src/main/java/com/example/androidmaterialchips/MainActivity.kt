package com.example.androidmaterialchips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment.newInstance()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun onFragmentInteractionEntryButtonPressed() {
        val fragment = EntryChipDemoFragment.newInstance()
        goToFragment(fragment)
    }

    override fun onFragmentInteractionChoiceButtonPressed() {
        val fragment = ChoiceChipDemoFragment.newInstance()
        goToFragment(fragment)
    }

    override fun onFragmentInteractionFilterButtonPressed() {
        val fragment = FilterChipDemoFragment.newInstance()
        goToFragment(fragment)
    }

    override fun onFragmentInteractionActionButtonPressed() {
        val fragment = ActionChipDemoFragment.newInstance()
        goToFragment(fragment)
    }

    private fun goToFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commitAllowingStateLoss()
    }


}
