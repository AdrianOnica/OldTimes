package com.example.oldtimesapp

import android.content.Contex
import android.content.Context
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable
import android.health.connect.datatypes.AppInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oldtimesapp.ui.theme.OldTimesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OldTimesAppTheme {
                MainPage()
            }
        }
        getInstalledApps(this)
    }
}

fun getInstalledApps(context: Context) {
    val packageManager = context.packageManager
    val packages: List<PackageInfo> = packageManager.getInstalledPackages(0)

    val installedApps = mutableListOf<AppInfo>()

    for (packageInfo in packages) {
        val appName = packageInfo.applicationInfo.loadLabel(packageManager).toString()
        val packageName = packageInfo.packageName
        val appIcon: Drawable = packageInfo.applicationInfo.loadIcon(packageManager)
        // Add the app info to the list
    }
}

@Preview(showBackground = true)
@Composable
fun MainPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            MainPhonePage()
            ButtonsPart()
        }
    }
}

@Composable
fun MenuPage() {
    Box(modifier = Modifier.fillMaxWidth().height(350.dp).background(Color.Blue)) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
        }
    }
}

@Composable
private fun MainPhonePage() {
    Box(modifier = Modifier.fillMaxWidth().height(350.dp).background(Color.Blue)) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text("11:36 pm", fontSize = 26.sp)
            Text("Duminica, 07.05.2017", fontSize = 18.sp)
        }
        Row(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Message")
            Text("Menu")
            Text("Camera")
        }
    }
}

@Composable
private fun ButtonsPart() {
    var count = 0
    Box(modifier = Modifier.fillMaxWidth().height(400.dp).background(Color.White).padding(bottom = 16.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Black))
            Column(
                modifier = Modifier.fillMaxSize().padding(start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(3) {
                            count++
                            Text(count.toString(), fontSize = 20.sp)
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("*", fontSize = 20.sp)
                    Text("0", fontSize = 20.sp)
                    Text("#", fontSize = 20.sp)
                }
            }
        }
    }
}
