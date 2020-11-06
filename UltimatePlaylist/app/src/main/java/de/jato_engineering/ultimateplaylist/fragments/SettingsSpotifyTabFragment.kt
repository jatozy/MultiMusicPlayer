package de.jato_engineering.ultimateplaylist.fragments

import android.R.attr.button
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.jato_engineering.ultimateplaylist.R


class SettingsSpotifyTabFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val spotifyTab: View = inflater.inflate(R.layout.fragment_settings_spotify_tab, container, false)
        val connectButton: Button = spotifyTab.findViewById<Button>(R.id.settings_spotify_test_connection)

        connectButton.setOnClickListener(View.OnClickListener {
            val stateText: TextView = spotifyTab.findViewById<TextView>(R.id.settings_spotify_connection_state)
            val username: EditText = spotifyTab.findViewById<EditText>(R.id.settings_spotify_value_username)
            stateText.text = username.text
        })

        return spotifyTab
    }
}