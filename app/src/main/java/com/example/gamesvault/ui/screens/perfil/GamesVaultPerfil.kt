import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gamesvault.ui.commons.BarraDeNavegacion
import com.example.gamesvault.ui.screens.perfil.GamesVaultPerfilState
import com.example.gamesvault.ui.screens.perfil.GamesVaultPerfilViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun GamesVaultPerfil(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onLogOutClick: ()-> Unit,
    vm: GamesVaultPerfilViewModel =  viewModel()

) {


    val formatoFecha = remember {
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
            timeZone = TimeZone.getDefault()
        }
    }
    val formatoHora = remember {
        SimpleDateFormat("HH:mm:ss", Locale.getDefault()).apply {
            timeZone = TimeZone.getDefault()
        }
    }
    val fechaCreacion = remember { formatoFecha.format(Date(vm.uiState.creacion_cuenta)) }

    val fechaUltimoLogin = remember { formatoFecha.format(Date(vm.uiState.ultimo_login)) }
    val horaUltimoLogin = remember { formatoHora.format(Date(vm.uiState.ultimo_login)) }


    Scaffold(
        bottomBar = {
            BarraDeNavegacion(navController = navController)
        },
        containerColor = Color(0xFF020817) // Fondo general
    ) { paddingValues ->
        Column(Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())) {
            Text(
                text = "Mi Perfil",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            // Box de "Información Personal"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Transparent, shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)))
                    .border(1.dp, Color(0xFF121B2B), MaterialTheme.shapes.medium)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Titulo principal
                    Text(
                        text = "Información Personal",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    // Subtitulo
                    Text(
                        text = "Gestiona tu información personal",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.Light
                        )
                    )
                    // Imagen redonda (Foto de perfil)
                    //si la url de la no imagen es "" muestra la foto de perfil, sino un circulo vacio
                    if (vm.uiState.foto_url.length>1){
                        AsyncImage(
                            model = vm.uiState.foto_url,
                            contentDescription = "foto de perfil de: " + vm.uiState.username  ,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color(0xFF121B2B), CircleShape)

                        )
                    }else{
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color(0xFF121B2B), CircleShape)
                        )
                    }


                    // Nombre de usuario
                    Text(
                        text = vm.uiState.username,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    // Correo electrónico
                    Text(
                        text =  vm.uiState.email,
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )
                }
            }

            Spacer(modifier)

            // Box de "Estadísticas"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Transparent, shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)))
                    .border(1.dp, Color(0xFF121B2B), MaterialTheme.shapes.medium)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Titulo principal
                    Text(
                        text = "Estadísticas",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    // Texto con icono y cantidad de juegos favoritos
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder, // Asegúrate de agregar el icono de corazón
                            contentDescription = "Icono de corazón",
                            tint = Color(0xFF7C3AED),
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Juegos favoritos",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Light
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // Cantidad de juegos favoritos
                    Text(
                        text = "Tienes 12 Juegos favoritos",
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                    )

                    // Botón "Ver favoritos"
                    Button(
                        onClick = { /* Acción para ver favoritos */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF121B2B)),
                        shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp))
                    ) {
                        Text(
                            text = "Ver favoritos",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier)

            // Box de "Actividad"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Transparent, shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)))
                    .border(1.dp, Color(0xFF121B2B), MaterialTheme.shapes.medium)
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Titulo principal
                    Text(
                        text = "Actividad",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    // Titulo secundario "Último inicio de sesión"
                    Text(
                        text = "Último inicio de sesión",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    )

                    // Información del último inicio de sesión
                    Text(
                        text = "$fechaUltimoLogin" + " " + "$horaUltimoLogin",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )

                    // Barra separadora
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color(0xFF121B2B)
                    )

                    // Titulo secundario "Cuenta creada"
                    Text(
                        text = "Cuenta creada",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    )

                    // Información de la cuenta creada
                    Text(
                        text = "$fechaCreacion",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )

                    // Barra separadora
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color(0xFF121B2B)
                    )

                    // Botón "Cerrar sesión"
                    Button(
                        onClick = onLogOutClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff721B1C)),
                        shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp))
                    ) {
                        Text(
                            text = "Cerrar sesión",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPerfil() {
    val context = LocalContext.current
    // Crear un NavHostController vacío o de prueba
    val navController = remember { NavHostController(context) }

    GamesVaultPerfil(
        navController = navController,
        onLogOutClick = { Log.e("funciono", "d") } // Acción para la función de log out
    )
}