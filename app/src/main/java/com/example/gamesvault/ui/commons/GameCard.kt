package com.example.gamesvault.ui.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gamesvault.data.JuegoSummary

@Composable
fun GameCard(
    juego: JuegoSummary,
    onClick: (juegoId: Int) -> Unit,
    onFavClick: (juegoId: Int) -> Unit,
    isFavorite: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(juego.id) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0x00ffffff)),
        border = BorderStroke(1.dp, Color(0xff121B2B))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = juego.urlImagen,
                contentDescription = juego.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = juego.title.uppercase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                FavoriteButton(
                    onToggle = { onFavClick(juego.id) },
                    isFavorite = isFavorite,
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = juego.descripcionCorta,
                fontSize = 14.sp,
                color = Color.LightGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = juego.genre,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = juego.platform,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}
