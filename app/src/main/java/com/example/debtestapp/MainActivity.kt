package com.example.debtestapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.debtestapp.ui.theme.DEBTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val preferences = applicationContext.getSharedPreferences("prefs.db", Context.MODE_PRIVATE);
        val data = preferences.getString("stringKey", null)
        if (data != null) {
            preferences.getBoolean("isAppetize", false)
            setContent {
                DEBTestAppTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Greeting(
                                name = data,
                                modifier = Modifier.padding(innerPadding)
                            )
                    }
                }
            }
        } else {
            setContent {
                DEBTestAppTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Greeting(
                                name = "Capital One",
                                modifier = Modifier.padding(innerPadding)
                            )
                    }
                }
            }
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DEBTestAppTheme {
        Greeting("Android")
    }
}