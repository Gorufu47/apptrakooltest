package com.example.trakooltest2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_tenpoint.*
import okhttp3.*
import java.io.IOException

class TenPoint : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenpoint)
        studentView.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }

    private fun fetchJson() {

        val url = "http://192.168.2.111/android/get_post.php"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                if(body != "") {
//                    Log.d("Body", body)
                    val gson = GsonBuilder().create()
                    val studentAll = gson.fromJson(body, StudentAll::class.java)
                    runOnUiThread {
                        studentView.adapter = StudentAdapter(studentAll)
                    }
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_ITEM_ADD) {
        if (resultCode == Activity.RESULT_OK) {
            fetchJson()
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this@TenPoint, "Result Cancel", Toast.LENGTH_SHORT).show()
        }
//        }
    }
}
class StudentAll(val student : List<Student>)

data class Student(val ID : Int , val NameTH : String ,  val StudentID : String , val Major : String)