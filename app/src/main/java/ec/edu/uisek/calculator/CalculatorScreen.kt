package ec.edu.uisek.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorScreen() {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 36.sp,
                textAlign = TextAlign.End,
                color = Color.White
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            ),
            singleLine = true
        )

        CalculatorGrid(onButtonClick = { label ->
            when (label) {
                "=" -> {
                }
                else -> {
                    inputText += label
                }
            }
        })
    }
}

@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        "7", "8", "9", "÷",
        "4", "5", "6", "×",
        "1", "2", "3", "−",
        "0", ".", "=", "+"
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(buttons) { label ->
            CalculatorButton(label = label) {
                onButtonClick(label)
            }
        }
    }
}

@Composable
fun CalculatorButton(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .background(Color.DarkGray, shape = MaterialTheme.shapes.medium)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorScreen() {
    CalculatorScreen()
}