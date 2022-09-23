package com.skokcmd.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // roll button handle click
        val rollButton: Button = findViewById(R.id.roll_button)
        val rollResult: TextView = findViewById(R.id.roll_result_text)
        val rollImage: ImageView = findViewById(R.id.roll_icon)

        handleRoll(rollButton, rollResult, rollImage)
    }

    private fun handleRoll(button: Button, textView: TextView, rollImage: ImageView) {
        button.setOnClickListener {
            displayRolledNumberText(textView)
            animateDiceImage(rollImage, 360F)
        }
        rollImage.setOnClickListener {
            displayRolledNumberText(textView)
            animateDiceImage(rollImage, 360F)
        }
    }

    private fun rollNumber(from: Int, to: Int): Int {
        val random = Random()
        return random.nextInt(to - from) + from
    }

    private fun animateDiceImage(imageView: ImageView, degrees: Float) {
        imageView.animate().rotation(imageView.rotation + degrees).start()
    }

    private fun displayRolledNumberText(textView: TextView) {
        textView.height = 250
        textView.visibility = TextView.VISIBLE
        textView.text = rollNumber(0, 200).toString()
    }
}