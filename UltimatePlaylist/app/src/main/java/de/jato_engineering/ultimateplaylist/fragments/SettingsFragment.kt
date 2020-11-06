package de.jato_engineering.ultimateplaylist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import de.jato_engineering.ultimateplaylist.R

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        val settingsFragment: View = inflater.inflate(R.layout.fragment_settings, container, false)
        val tabs : TabLayout? = settingsFragment.findViewById<TabLayout>(R.id.settings_streaming_tabs)

        val settingsSoundcloudTabFragment = SettingsSoundcloudTabFragment()
        val settingsSpotifyTabFragment = SettingsSpotifyTabFragment()

        makeCurrentFragment(settingsSpotifyTabFragment)

        tabs?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.text) {
                    getString(R.string.spotify_name) -> makeCurrentFragment(settingsSpotifyTabFragment)
                    getString(R.string.soundcloud_name) -> makeCurrentFragment(settingsSoundcloudTabFragment)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return settingsFragment
    }

    override fun onDestroyView () {
        super.onDestroyView()
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.settings_tabs_area, fragment).commit()
    }
}