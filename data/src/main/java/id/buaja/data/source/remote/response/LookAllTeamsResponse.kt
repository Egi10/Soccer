package id.buaja.data.source.remote.response

import com.squareup.moshi.Json

data class LookAllTeamsResponse(

	@Json(name="teams")
	val teams: List<TeamsItem>? = null
)

data class TeamsItem(

	@Json(name="intStadiumCapacity")
	val intStadiumCapacity: String? = null,

	@Json(name="strTeamShort")
	val strTeamShort: String? = null,

	@Json(name="idLeague3")
	val idLeague3: String? = null,

	@Json(name="idLeague2")
	val idLeague2: String? = null,

	@Json(name="idLeague5")
	val idLeague5: Any? = null,

	@Json(name="strSport")
	val strSport: String? = null,

	@Json(name="idLeague4")
	val idLeague4: Any? = null,

	@Json(name="idLeague7")
	val idLeague7: Any? = null,

	@Json(name="strDescriptionCN")
	val strDescriptionCN: Any? = null,

	@Json(name="idLeague6")
	val idLeague6: Any? = null,

	@Json(name="strTeamJersey")
	val strTeamJersey: String? = null,

	@Json(name="strTeamFanart2")
	val strTeamFanart2: String? = null,

	@Json(name="strTeamFanart3")
	val strTeamFanart3: String? = null,

	@Json(name="strTeamFanart4")
	val strTeamFanart4: String? = null,

	@Json(name="strStadiumDescription")
	val strStadiumDescription: String? = null,

	@Json(name="strTeamFanart1")
	val strTeamFanart1: String? = null,

	@Json(name="intLoved")
	val intLoved: String? = null,

	@Json(name="idLeague")
	val idLeague: String? = null,

	@Json(name="idSoccerXML")
	val idSoccerXML: String? = null,

	@Json(name="strTeamLogo")
	val strTeamLogo: String? = null,

	@Json(name="strDescriptionSE")
	val strDescriptionSE: Any? = null,

	@Json(name="strDescriptionJP")
	val strDescriptionJP: String? = null,

	@Json(name="strDescriptionFR")
	val strDescriptionFR: String? = null,

	@Json(name="strStadiumLocation")
	val strStadiumLocation: String? = null,

	@Json(name="strDescriptionNL")
	val strDescriptionNL: Any? = null,

	@Json(name="strCountry")
	val strCountry: String? = null,

	@Json(name="strRSS")
	val strRSS: String? = null,

	@Json(name="strDescriptionRU")
	val strDescriptionRU: String? = null,

	@Json(name="strTeamBanner")
	val strTeamBanner: String? = null,

	@Json(name="strDescriptionNO")
	val strDescriptionNO: String? = null,

	@Json(name="strStadiumThumb")
	val strStadiumThumb: String? = null,

	@Json(name="strDescriptionES")
	val strDescriptionES: String? = null,

	@Json(name="intFormedYear")
	val intFormedYear: String? = null,

	@Json(name="strInstagram")
	val strInstagram: String? = null,

	@Json(name="strDescriptionIT")
	val strDescriptionIT: String? = null,

	@Json(name="idTeam")
	val idTeam: String? = null,

	@Json(name="strDescriptionEN")
	val strDescriptionEN: String? = null,

	@Json(name="strWebsite")
	val strWebsite: String? = null,

	@Json(name="strYoutube")
	val strYoutube: String? = null,

	@Json(name="strDescriptionIL")
	val strDescriptionIL: Any? = null,

	@Json(name="idAPIfootball")
	val idAPIfootball: String? = null,

	@Json(name="strLocked")
	val strLocked: String? = null,

	@Json(name="strAlternate")
	val strAlternate: String? = null,

	@Json(name="strTeam")
	val strTeam: String? = null,

	@Json(name="strTwitter")
	val strTwitter: String? = null,

	@Json(name="strDescriptionHU")
	val strDescriptionHU: Any? = null,

	@Json(name="strGender")
	val strGender: String? = null,

	@Json(name="strDivision")
	val strDivision: Any? = null,

	@Json(name="strStadium")
	val strStadium: String? = null,

	@Json(name="strFacebook")
	val strFacebook: String? = null,

	@Json(name="strTeamBadge")
	val strTeamBadge: String? = null,

	@Json(name="strLeague2")
	val strLeague2: String? = null,

	@Json(name="strLeague3")
	val strLeague3: String? = null,

	@Json(name="strLeague4")
	val strLeague4: String? = null,

	@Json(name="strLeague5")
	val strLeague5: String? = null,

	@Json(name="strDescriptionPT")
	val strDescriptionPT: String? = null,

	@Json(name="strLeague6")
	val strLeague6: String? = null,

	@Json(name="strDescriptionDE")
	val strDescriptionDE: String? = null,

	@Json(name="strLeague7")
	val strLeague7: String? = null,

	@Json(name="strLeague")
	val strLeague: String? = null,

	@Json(name="strManager")
	val strManager: String? = null,

	@Json(name="strKeywords")
	val strKeywords: String? = null,

	@Json(name="strDescriptionPL")
	val strDescriptionPL: Any? = null
)