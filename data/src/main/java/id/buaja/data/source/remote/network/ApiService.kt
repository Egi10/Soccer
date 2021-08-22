package id.buaja.data.source.remote.network

import id.buaja.data.source.remote.response.AllLeaguesResponse
import id.buaja.data.source.remote.response.LookAllTeamsResponse
import id.buaja.data.source.remote.response.LookUpLeagueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("all_leagues.php")
    suspend fun getAllLeagues(): AllLeaguesResponse

    @GET("lookupleague.php")
    suspend fun getDetailLeagues(
        @Query("id") id: String
    ): LookUpLeagueResponse

    @GET("lookup_all_teams.php")
    suspend fun getAllTeamByIdLeagues(
        @Query("id") id: String
    ): LookAllTeamsResponse
}