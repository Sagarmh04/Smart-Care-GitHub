package com.example.smartcare.ui.screen

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.Serializable

@Composable
fun EmergencyRide() {
    var showDialog by remember { mutableStateOf(false) }
    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var emergencyRequests by remember { mutableStateOf(listOf<EmergencyRequest>()) }

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFECF0F1))) {
        TopAppBar(
            title = { Text("Emergency Requests", color = Color.White) },
            backgroundColor = Color(0xFF1ABC9C)
        )

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1ABC9C))
        ) {
            Text("Post Emergency Request", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(emergencyRequests) { request ->
                EmergencyRequestCard(request)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Post an Emergency Request") },
            text = {
                Column {
                    OutlinedTextField(value = from, onValueChange = { from = it }, label = { Text("From") }, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = to, onValueChange = { to = it }, label = { Text("To") }, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = time, onValueChange = { time = it }, label = { Text("Time") }, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = reason, onValueChange = { reason = it }, label = { Text("Reason") }, modifier = Modifier.fillMaxWidth())
                }
            },
            confirmButton = {
                Button(onClick = {
                    val newRequest = EmergencyRequest(from, to, time, reason)
                    emergencyRequests = emergencyRequests + newRequest
                    showDialog = false
                }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1ABC9C))) {
                    Text("Submit", color = Color.White)
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun EmergencyRequestCard(request: EmergencyRequest) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {},
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Emergency Request", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF2C3E50))
            Text("From: ${request.from} → To: ${request.to}", fontSize = 14.sp, color = Color.Gray)
            Text("Time: ${request.time}", fontSize = 14.sp, color = Color.Gray)
            Text("Reason: ${request.reason}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1ABC9C))
        }
    }
}

data class EmergencyRequest(
    val from: String,
    val to: String,
    val time: String,
    val reason: String
)
