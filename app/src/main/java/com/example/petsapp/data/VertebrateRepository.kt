package com.example.petsapp.data


class VertebrateRepository (private val dao: VertebrateDao ){
    suspend fun insertCommand(vertebrate: Vertebrate) = dao.insert(vertebrate)
    suspend fun removeCommand(vertebrate: Vertebrate) = dao.delete(vertebrate)
    fun getAllCommand() = dao.getall()
}