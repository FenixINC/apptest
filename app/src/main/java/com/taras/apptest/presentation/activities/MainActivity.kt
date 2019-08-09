package com.taras.apptest.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taras.apptest.R
import com.taras.apptest.presentation.fragments.CommentsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.app_name)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, CommentsFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
