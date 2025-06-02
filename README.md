# 🎮 GamesVault - Tu Biblioteca de Videojuegos Móvil  

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen)](https://android-arsenal.com/api?level=24)

Aplicación Android para descubrir, explorar y guardar tus videojuegos favoritos. Conectada a una API externa para obtener datos actualizados.

<p align="center">
  <img src="https://github.com/ValentinoCattaneoLuna/gamesVault/blob/main/screenshots/demo.gif?raw=true" width="300" alt="Demo">
</p>

## ✨ Características Principales
- ✅ Búsqueda de juegos por nombre, género o plataforma  
- 🔍 Detalles completos de cada juego (descripción, rating, fecha de lanzamiento)  
- ❤️ Sistema de favoritos con persistencia local  
- 👤 Autenticación de usuarios (registro/login)  
- 📱 Interfaz moderna con Material Design 3  

## 🛠 Tecnologías Utilizadas
| Categoría       | Tecnologías                                                                 |
|-----------------|----------------------------------------------------------------------------|
| **Lenguaje**    | Kotlin                                                                     |
| **Arquitectura**| MVVM (Model-View-ViewModel)                                                |
| **Jetpack**     | ViewModel, LiveData, Navigation Component                                  |
| **Networking**  | Retrofit + Gson                                                            |
| **Persistencia**| SharedPreferences (Room próximamente)                                      |
| **UI**          | Jetpack Compose                                                            |

## 📸 Capturas de Pantalla
<div align="center">
  <img src="screenshots/home.jpg" width="200" alt="Home">
  <img src="screenshots/details.jpg" width="200" alt="Detalles">
  <img src="screenshots/search.jpg" width="200" alt="Búsqueda">
  <img src="screenshots/profile.jpg" width="200" alt="Perfil">
</div>

## ⚙️ Configuración
1. Clona el repositorio:
   ```bash
   git clone https://github.com/ValentinoCattaneoLuna/gamesVault.git
