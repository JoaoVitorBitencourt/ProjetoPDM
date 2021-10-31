package com.example.projetopdm.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.projetopdm.R;

import java.util.Set;

public class Shared {

    private static Context activity;

    public Shared (Context activity) {
        this.activity = activity;
    }

    public static final void put(final String key, final Object value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();

        if(value instanceof String){
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        } else {
            Toast.makeText(activity, R.string.dadoInvalido, Toast.LENGTH_LONG).show();
        }

        editor.apply();
    }

    public static final String getString(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getString(key, "");
    }
    public static final boolean getBoolean(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean(key, false);
    }
    public static final float getFloat(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getFloat(key, 0.00f);
    }
    public static final Set getStringSet(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getStringSet(key, null);
    }
    public static final long getLong(final String key) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getLong(key,0);
    }
}
