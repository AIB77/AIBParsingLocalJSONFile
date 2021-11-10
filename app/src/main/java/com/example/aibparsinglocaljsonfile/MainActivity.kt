package com.example.aibparsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aibparsinglocaljsonfile.assets.DataItem
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    lateinit var RV:RecyclerView
    val detailsArray=ArrayList<DataItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RV=findViewById(R.id.rv)

        RV.adapter = RecyclerViewAdapter(detailsArray,this)
        RV.layoutManager = LinearLayoutManager(this)

        read_json()
    }

    fun read_json() {
        var json: String?
        try {
            val inputStream: InputStream = assets.open("Data.json")
            json = inputStream.bufferedReader().use { it.readText() }
            var jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {

                val jsonObject=jsonArray.getJSONObject(i)
                val copyright=jsonObject.getString("copyright")
                val date=jsonObject.getString("date")
                val explanation=jsonObject.getString("explanation")
                val title=jsonObject.getString("title")
                val url=jsonObject.getString("url")



                detailsArray.add(DataItem(copyright,date,explanation,title,url))

            }
            RV.adapter!!.notifyDataSetChanged()


        } catch (e: IOException) {
            Log.e("EXCEPTION",e.toString())
        }

    }
}