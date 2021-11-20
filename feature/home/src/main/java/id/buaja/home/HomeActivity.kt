package id.buaja.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import id.buaja.home.ui.home.HomeScreen
import id.buaja.home.ui.home.HomeViewModel
import id.buaja.home.ui.theme.SoccerTheme
import id.buaja.team.TeamActivity

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val viewModel by viewModels<HomeViewModel>()

    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoccerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(viewModel = viewModel) {
                        val intent = Intent(this, TeamActivity::class.java)
                        intent.putExtra(TeamActivity.ID_LEAGUE, it.idLeague)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}