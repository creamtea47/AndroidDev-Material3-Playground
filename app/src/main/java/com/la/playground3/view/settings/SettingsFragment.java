package com.la.playground3.view.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.la.playground3.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    BottomNavigationView mBottomNavigationView;

    public SettingsFragment(BottomNavigationView mainBnv) {
        mBottomNavigationView = mainBnv;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}