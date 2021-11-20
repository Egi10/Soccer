package id.buaja.team.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import id.buaja.team.TeamActivity

@AndroidEntryPoint
class ListTeamFragment : Fragment() {
    private val viewModel by viewModels<ListTeamViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            val uiState by viewModel.uiState.collectAsState()

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
                    LazyColumn(
                        content = {
                            items(items = uiState.data ?: emptyList()) { team ->
                                Row {
                                    Image(
                                        painter = rememberImagePainter(
                                            data = team.strTeamBadge
                                        ),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(80.dp)
                                    )
                                    Text(text = team.strTeam)
                                }
                            }
                        }
                    )
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idLeague = activity?.intent?.getStringExtra(TeamActivity.ID_LEAGUE)
        viewModel.getAllTeam(idLeague ?: "")
    }
}