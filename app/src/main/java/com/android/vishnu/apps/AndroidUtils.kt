package com.android.vishnu.apps

import android.content.Context
import android.content.SharedPreferences


class AndroidUtils {

    companion object {
        var USER_NAME = "userName"
        var BEST_CRICKETER = "bestCricket"
        var NATION_FLAG_COLOR = "national_flag_color"

        fun getString(context: Context, key: String): String? {
            val sharedpreferences: SharedPreferences =
                context.getSharedPreferences("appscript", Context.MODE_PRIVATE)
            return sharedpreferences.getString(key,null)
        }

        fun setString(context: Context, key: String, value: String) {
            val sharedpreferences: SharedPreferences =
                context.getSharedPreferences("appscript", Context.MODE_PRIVATE)
            val editor = sharedpreferences.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }


}