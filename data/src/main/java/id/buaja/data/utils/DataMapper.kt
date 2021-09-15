package id.buaja.data.utils

import id.buaja.data.source.remote.response.LeaguesItem
import id.buaja.domain.model.LeaguesModel

object DataMapper {
    fun mapResponseToModel(list: List<LeaguesItem>): List<LeaguesModel> {
        val newList: MutableList<LeaguesModel> = mutableListOf()

        list.map {
            newList.add(
                LeaguesModel(
                    strName = it.strLeague ?: ""
                )
            )
        }

        return newList
    }
}