package com.ctl.firebaseretrieveimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ctl.firebaseretrieveimages.storage.RecyclerImageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, RecyclerImageActivity::class.java)
        startActivity(intent)
        finish()
    }
}