package com.example.trakooltest2

//import android.view.View
//import android.widget.Toast
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    private lateinit var mainGrid: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainGrid = findViewById(R.id.mainGrid)

        //Set Event
        setSingleEvent(mainGrid)
    }


    private fun setSingleEvent(mainGrid: GridLayout) {
        //Loop all child item of Main Grid
        for (i in 0 until mainGrid.childCount) {
            //You can see , all child item is CardView , so we just cast object to CardView
            val cardView = mainGrid.getChildAt(i) as androidx.cardview.widget.CardView
            cardView.setOnClickListener {
                //                Toast.makeText(this@MainActivity, "Clicked at index$i", Toast.LENGTH_LONG).show()
                if (cardView.cardBackgroundColor.defaultColor == -1) {
                    //Change background color
                    cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"))
                    if (i in 0..0) {
                        val myIntent = Intent(applicationContext, TenPoint::class.java)
                        startActivity(myIntent)
                    }
                    if (i in 5..5) {
                        val myIntent = Intent(applicationContext, MainInfo::class.java)
                        startActivity(myIntent)
                    }
                }
                Timer("SettingUp", false).schedule(500) {
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                }

            }
        }
    }
//    private fun goToInfo() {
//        val myIntent = Intent(applicationContext, Information::class.java)
//        startActivity(myIntent)
//    }
}