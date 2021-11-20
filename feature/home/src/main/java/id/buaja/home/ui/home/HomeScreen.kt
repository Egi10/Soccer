package id.buaja.home.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import id.buaja.domain.model.LeaguesModel

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onClick: (LeaguesModel) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        Text(
            text = "Competitions",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        when {
            uiState.loading -> {
                Spacer(modifier = Modifier.padding(top = 20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            uiState.data != null -> {
                val data = uiState.data ?: emptyList()

                LazyVerticalGrid(
                    cells = GridCells.Fixed(3)
                ) {
                    items(data) { league ->
                        LeagueRow(
                            leagues = league,
                            onClick = onClick
                        )
                    }
                }
            }
            else -> {
                Text(
                    text = uiState.error,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun LeagueRow(
    leagues: LeaguesModel,
    onClick: (LeaguesModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 5.dp, end = 5.dp)
            .clickable {
                onClick.invoke(leagues)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(
                data = leagues.strBadge
            ),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = leagues.strLeague,
            fontSize = 14.sp,
            style = TextStyle(
                textAlign = TextAlign.Center,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}