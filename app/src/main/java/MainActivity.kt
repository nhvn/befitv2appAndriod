class MainActivity {
}package com.example.befit // Replace with your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeFitApp()
        }
    }
}

@Composable
fun BeFitApp() {
    var isDarkMode by remember { mutableStateOf(false) }

    MaterialTheme(
        colors = if (isDarkMode) darkColors() else lightColors()
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Top bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = if (isDarkMode) R.drawable.befit_dark else R.drawable.befit_light),
                        contentDescription = "BeFit Logo",
                        modifier = Modifier.height(30.dp)
                    )
                    Row {
                        IconButton(onClick = { isDarkMode = !isDarkMode }) {
                            Icon(
                                painter = painterResource(id = if (isDarkMode) R.drawable.ic_moon else R.drawable.ic_sun),
                                contentDescription = "Toggle dark mode"
                            )
                        }
                        Button(
                            onClick = { /* Login action */ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = if (isDarkMode) Color.White else Color.Black)
                        ) {
                            Text(
                                "Login",
                                color = if (isDarkMode) Color.Black else Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "Unlock Your Best Self: Your Ultimate Progress Tracking Companion!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Buttons Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* Documentation action */ },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                    ) {
                        Text("Documentation", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = { /* GitHub action */ },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
                    ) {
                        Text("GitHub", color = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.mission_login),
                    contentDescription = "Mission Login",
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "From Doubt to Determination: The BeFit Success Story",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "In a world where busy schedules, endless distractions, and self-doubt often derail our fitness ambitions, there emerged a powerful solution – BeFit. This is the story of how one innovative app transformed the lives of countless individuals, empowering them to take control of their fitness journey.",
                    color = Color(0xFF758498)
                )
            }
        }
    }
}