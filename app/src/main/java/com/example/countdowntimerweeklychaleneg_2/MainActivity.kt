package com.example.countdowntimerweeklychaleneg_2

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : AppCompatActivity() {
    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarComponentWithText()
        }
    }

    @Composable
    fun TopAppBarComponentWithText() {
        //Using MutableState in Compose
        val counterState = remember { mutableStateOf(0) }
        Column {
            TopAppBar(
                title = { Text(text = "State Management", color = Color.White) },
                backgroundColor = Color.Blue
            )
            Text(
                text = counterState.value.toString(),
                Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
                textAlign = TextAlign.Center

            )
            Button(
                onClick = {
                    object : CountDownTimer(10000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            counterState.value = counter++
                        }
                        override fun onFinish() {
                            counterState.value = 0
                            Toast.makeText(
                                this@MainActivity,
                                "Reset Counter",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }.start()
                }, Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
            ) {
                Text(text = "Start Timer for 10 Second")
            }
        }
    }
}
