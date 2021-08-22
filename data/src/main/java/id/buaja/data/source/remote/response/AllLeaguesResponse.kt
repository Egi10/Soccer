package id.buaja.data.source.remote.response

import com.squareup.moshi.Json

data class AllLeaguesResponse(

	@Json(name="leagues")
	val leaguesDetail: List<LeaguesItem>? = null
)

data class LeaguesItem(

	@Json(name="strLeagueAlternate")
	val strLeagueAlternate: String? = null,

	@Json(name="strLeague")
	val strLeague: String? = null,

	@Json(name="strSport")
	val strSport: String? = null,

	@Json(name="idLeague")
	val idLeague: String? = null
)
