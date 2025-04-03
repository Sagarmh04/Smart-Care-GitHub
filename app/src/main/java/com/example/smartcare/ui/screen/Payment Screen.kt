package com.example.smartcare.ui.screen

// PaymentPage.kt
import AppTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartcare.AppointmentLists
import com.example.smartcare.Hospitals.allHospitalData
import com.example.smartcare.viewModel.AppointmentViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentPage(navController: NavController) {
    // State for selected payment method
    var selectedMethod by remember { mutableStateOf<PaymentMethod?>(null) }
    val appointmentDetails = navController.previousBackStackEntry?.savedStateHandle?.get<AppointmentLists>("data")
    // Light and attractive color palette
    val backgroundColor = Color(0xFFF5F5F5)
    val cardColor = Color(0xFFFFFFFF)
    val primaryColor = Color(0xFF6200EE)
    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser
    Scaffold(
        modifier = Modifier.background(backgroundColor),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Payment",
                        style = AppTheme.typography.heading,
                        color = primaryColor
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = cardColor
                )
            )
        },
        content = {innerpadding->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerpadding)
                    .background(backgroundColor),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Payment Methods
                PaymentMethod.values().forEach { method ->
                    PaymentMethodCard(
                        method = method,
                        isSelected = selectedMethod == method,
                        onClick = { selectedMethod = if (selectedMethod == method) null else method },
                        cardColor = cardColor,
                        primaryColor = primaryColor
                    )

                    // Show details only for the selected method
                    AnimatedVisibility(
                        visible = selectedMethod == method,
                        enter = slideInVertically(animationSpec = tween(250)) + fadeIn(animationSpec = tween(200)),
                        exit = slideOutVertically(animationSpec = tween(50)) + fadeOut(animationSpec = tween(100))
                    ) {
                        when (method) {
                            PaymentMethod.CREDIT_CARD -> CreditCardDetails()
                            PaymentMethod.DEBIT_CARD -> DebitCardDetails()
                            PaymentMethod.UPI -> UpiDetails()
                            PaymentMethod.WALLET -> WalletDetails()
                            PaymentMethod.CASH_ON_DELIVERY -> CashOnDeliveryDetails()
                        }
                    }
                }

                // Pay Button
                Button(
                    onClick = {
                            if (appointmentDetails != null) {
                                allHospitalData[appointmentDetails.hospitalDataIndex].hospitals[appointmentDetails.hospitalIndex].doctors[appointmentDetails.doctorIndex].appointments[appointmentDetails.appointmentIndex] = false
                            }
                        if (user != null) {
                            val newAppointment = AppointmentLists(
                                id = appointmentDetails?.id ?:0,
                                doctorName = appointmentDetails?.doctorName ?: "",
                                doctorImageUrl = appointmentDetails?.doctorImageUrl ?: "",
                                date = appointmentDetails?.date ?: "",
                                time = appointmentDetails?.time ?: "",
                                reason = appointmentDetails?.reason ?: "",
                                status = appointmentDetails?.status ?: "",
                                isCompleted = appointmentDetails?.isCompleted ?: false,
                                hospitalDataIndex = appointmentDetails?.hospitalDataIndex ?: 0,
                                hospitalIndex = appointmentDetails?.hospitalIndex ?: 0,
                                doctorIndex = appointmentDetails?.doctorIndex ?: 0,
                                appointmentIndex = appointmentDetails?.appointmentIndex ?: 0,
                                hospitalName = appointmentDetails?.hospitalName!!,
                                cityName = appointmentDetails.cityName
                            )

                            addAppointmentToFirestore(
                                userId = user.uid,
                                appointment = newAppointment,
                                onSuccess = {
                                },
                                onFailure = { e ->
                                }
                            )
                        }
                        navController.navigate("home") // Navigate to home after payment
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                ) {
                    Text("Pay Now", color = Color.White)
                }
            }
        })
}

@Composable
fun PaymentMethodCard(
    method: PaymentMethod,
    isSelected: Boolean,
    onClick: () -> Unit,
    cardColor: Color,
    primaryColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = method.displayName,
                style = AppTheme.typography.heading,
                color = if (isSelected) primaryColor else Color.Black
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Expand",
                tint = if (isSelected) primaryColor else Color.Gray
            )
        }
    }
}

@Composable
fun CreditCardDetails() {
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var cardHolder by remember { mutableStateOf(TextFieldValue()) }
    var expiryDate by remember { mutableStateOf(TextFieldValue()) }
    var cvv by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Card Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = cardHolder,
            onValueChange = { cardHolder = it },
            label = { Text("Card Holder Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = expiryDate,
                onValueChange = { expiryDate = it },
                label = { Text("MM/YY") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = cvv,
                onValueChange = { cvv = it },
                label = { Text("CVV") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}

@Composable
fun DebitCardDetails() {
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var cardHolder by remember { mutableStateOf(TextFieldValue()) }
    var expiryDate by remember { mutableStateOf(TextFieldValue()) }
    var cvv by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Card Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = cardHolder,
            onValueChange = { cardHolder = it },
            label = { Text("Card Holder Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = expiryDate,
                onValueChange = { expiryDate = it },
                label = { Text("MM/YY") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = cvv,
                onValueChange = { cvv = it },
                label = { Text("CVV") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}

@Composable
fun UpiDetails() {
    var upiId by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        OutlinedTextField(
            value = upiId,
            onValueChange = { upiId = it },
            label = { Text("UPI ID") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun WalletDetails() {
    var walletId by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        OutlinedTextField(
            value = walletId,
            onValueChange = { walletId = it },
            label = { Text("Wallet ID") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CashOnDeliveryDetails() {
    Text(
        text = "Pay when your order is delivered.",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

enum class PaymentMethod(val displayName: String) {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    UPI("UPI"),
    WALLET("Wallet"),
    CASH_ON_DELIVERY("Cash on Delivery")
}

fun addAppointmentToFirestore(
    userId: String,
    appointment: AppointmentLists,
    onSuccess: () -> Unit,
    onFailure: (Exception) -> Unit
) {
    val db = FirebaseFirestore.getInstance()

    // Generate a unique document ID for the appointment
    val appointmentRef = db.collection("users").document(userId)
        .collection("appointments").document()

    val appointmentData = mapOf(
        "id" to appointmentRef.id,  // Firestore-generated ID
        "doctorName" to appointment.doctorName,
        "doctorImageUrl" to appointment.doctorImageUrl,
        "date" to appointment.date,
        "time" to appointment.time,
        "reason" to appointment.reason,
        "status" to appointment.status,
        "isCompleted" to appointment.isCompleted
    )

    appointmentRef.set(appointmentData)
        .addOnSuccessListener { onSuccess() }
        .addOnFailureListener { e -> onFailure(e) }
}
