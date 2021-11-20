package id.buaja.data.utils

import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.data.source.remote.response.LookAllTeamsResponse
import id.buaja.domain.model.LeaguesModel
import id.buaja.domain.model.TeamModel

object DataMapper {
    fun mapResponseToModel(leagues: LeaguesItem, strBadge: String): List<LeaguesModel> {
        val newList: MutableList<LeaguesModel> = mutableListOf()

        newList.add(
            LeaguesModel(
                idLeague = leagues.idLeague ?: "",
                strLeague = leagues.strLeague ?: "",
                strBadge = strBadge
            )
        )

        return newList
    }

    fun mapResponseTeamToModel(team: LookAllTeamsResponse): List<TeamModel> {
        val newList: MutableList<TeamModel> = mutableListOf()

        team.teams?.map {
            newList.add(
                TeamModel(
                    strTeam = it.strTeam ?: "",
                    strTeamBadge = it.strTeamBadge ?: ""
                )
            )
        }

        return newList
    }
}