package id.buaja.data.utils

import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.domain.model.LeaguesModel

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
}