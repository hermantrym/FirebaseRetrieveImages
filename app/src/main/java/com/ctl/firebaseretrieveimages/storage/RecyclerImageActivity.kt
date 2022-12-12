package com.ctl.firebaseretrieveimages.storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctl.firebaseretrieveimages.R
import com.google.firebase.database.*

class RecyclerImageActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imagesList: ArrayList<UserImage>
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_image)

        recyclerView = findViewById(R.id.imageRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        imagesList = arrayListOf()

        databaseReference = FirebaseDatabase.getInstance().getReference("userImages")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val image = dataSnapShot.getValue(UserImage::class.java)
                        imagesList.add(image!!)
                    }
                    recyclerView.adapter = ImageAdapter(imagesList, this@RecyclerImageActivity)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RecyclerImageActivity, error.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}