package com.jetpack_compose_trainning_02

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import com.jetpack_compose_trainning_02.ui.theme.Jetpack_Compose_trainning_02Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                       Column(
                           modifier = Modifier.fillMaxSize(),
                          horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.SpaceAround

                       ) {
                           TestShow()
                       }
            }



        }


    }

@Composable
fun TestShow(){
    val counter = remember{mutableStateOf<Int>(0)}
    Text(text = "${counter.value}")
    Button(onClick = {
        CoroutineScope(Dispatchers.Main).launch {
            counter.value=0
            while(true) {
                delay(100)
                counter.value++}
        }
    }) {
        Text(text = "Click")
    }
}
