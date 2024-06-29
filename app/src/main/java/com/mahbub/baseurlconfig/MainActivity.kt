package com.mahbub.baseurlconfig

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahbub.baseurlconfig.environemnt.BuildType
import com.mahbub.baseurlconfig.environemnt.Env
import com.mahbub.baseurlconfig.ui.theme.BaseUrlConfigTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseUrlConfigTheme {
                App()
            }
        }
    }

}

@Composable
private fun App() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        var currentEnv by remember {
            mutableStateOf(Env.changeEnv(BuildType.PRODUCTION))
        }
        val currentBaseUrlServiceA by remember {
            derivedStateOf {
                when (currentEnv) {
                    BuildType.PRODUCTION -> Env.getUrlServiceA()
                    BuildType.STAGE -> Env.getUrlServiceB()
                    BuildType.DEV -> Env.getUrlServiceA()
                }
            }

        }
        val currentBaseUrlServiceB by remember {
            derivedStateOf {
                when (currentEnv) {
                    BuildType.PRODUCTION -> Env.getUrlServiceB()
                    BuildType.STAGE -> Env.getUrlServiceB()
                    BuildType.DEV -> Env.getUrlServiceB()
                }
            }

        }

        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            Text(
                text = "Service A:$currentBaseUrlServiceA",
            )
            Text(
                text = "Service B: $currentBaseUrlServiceB",
            )
            Button(onClick = {
                currentEnv = Env.changeEnv(BuildType.PRODUCTION)
            }) {
                Text(text = "Production version")
            }
            Button(onClick = {
                currentEnv = Env.changeEnv(BuildType.STAGE)
            }) {
                Text(text = "Stage version")
            }
            Button(onClick = {
                currentEnv = Env.changeEnv(BuildType.DEV)
            }) {
                Text(text = "Dev version")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaseUrlConfigTheme {
        App()
    }
}