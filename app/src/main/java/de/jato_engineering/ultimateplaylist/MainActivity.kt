package de.jato_engineering.ultimateplaylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.jato_engineering.ultimateplaylist.fragments.HomeFragment
import de.jato_engineering.ultimateplaylist.fragments.PlaylistFragment
import de.jato_engineering.ultimateplaylist.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val playlistFragment = PlaylistFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        val navigationBar = findViewById<BottomNavigationView>(R.id.main_navigation_bar)
        navigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_bar_home_view -> makeCurrentFragment(homeFragment)
                R.id.navigation_bar_playlist_view -> makeCurrentFragment(playlistFragment)
                R.id.navigation_bar_settings_view -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.pages_area, fragment)
            commit()
        }
}