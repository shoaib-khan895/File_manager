package com.example.storagepartsecond

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1
        );
        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 2
        );


        val path = Environment.getExternalStorageDirectory().toString()

        val myFile = File(path)
        if (myFile.isDirectory) {
            val arr = myFile.listFiles()
            val recycler_View = findViewById<RecyclerView>(R.id.recycler_View)
            val btn_back = findViewById<ImageView>(R.id.btn_back)
            recycler_View.adapter = ExampleAdapter(arr, btn_back,applicationContext,contentResolver,packageManager)
            recycler_View.layoutManager = LinearLayoutManager(this)
            recycler_View.setHasFixedSize(true)



        }
    }

}
