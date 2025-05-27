package com.example.gamesvault.ui.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBarWithButton(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderColor = Color(0xff121B2B)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(1.dp, bottom = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(7.dp))
                .padding(start = 8.dp, end = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    value = query,
                    onValueChange = onQueryChange,
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(
                        color = White,
                        fontSize = 14.sp
                    ),
                    cursorBrush = SolidColor(borderColor),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            if (query.isEmpty()) {
                Text(
                    text = "Buscar juegos...",
                    color = White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(
            onClick = onSearchClick,
            modifier = Modifier
                .height(40.dp)
                .defaultMinSize(minWidth = 80.dp),
            shape = RoundedCornerShape(7.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, borderColor)
        ) {
            Text("Buscar")
        }
    }
}
