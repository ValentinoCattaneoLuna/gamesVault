package com.example.gamesvault

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.example.gamesvault.data.local.JuegosDatabase
import com.example.gamesvault.ui.screens.NavigationStack
import com.example.gamesvault.ui.screens.Screens
import com.example.gamesvault.ui.theme.GamesVaultTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : ComponentActivity() {


    private lateinit var googleSigninClient: GoogleSignInClient

    private lateinit var navController: NavHostController

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { authResult ->
                    if (authResult.isSuccessful) {
                        navController.navigate(Screens.GamesVaultHome.route){
                            popUpTo(Screens.GamesVaultLogin.route) { inclusive = true }
                        }
                    }
                }
        } catch (e: ApiException) {
            Log.e("AUTH", "Error en Google Sign-In", e)
        }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //ver en casa
        //JuegosDatabase.createInstance(this)

        googleSigninClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).
                requestEmail().
                build()
        )

        setContent {
            navController = rememberNavController()
            GamesVaultTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack(
                        onLogOutClick = {

                            FirebaseAuth.getInstance().signOut()

                            navController.navigate(Screens.GamesVaultSplash.route) {
                                popUpTo("Perfil") { inclusive = true }
                                popUpTo("Home") { inclusive = true }
                            }
                        },
                        onGoogleLoginClick = {
                            launcher.launch(googleSigninClient.signInIntent)
                        },
                        navController = navController
                    )
                }
            }
        }
    }
}



