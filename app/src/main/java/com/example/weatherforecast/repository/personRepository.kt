package com.example.weatherforecast.repository

import com.example.weatherforecast.model.person

class personRepository {
    fun getAllData() : List<person>{
        return listOf(
            person(1,"A","kurku", 21),
            person(2,"B","Based", 22),
            person(3,"C","Cad", 23),
            person(4,"D","Ddf", 24),
            person(5,"E","Eadf", 25),
            person(6,"F","Fadf", 26),
            person(7,"G","Gadf", 27),
            person(8,"H","Had", 28),
            person(9,"I","Iadf", 29),
            person(10,"J","Jadf", 30),
            person(11,"K","Kadf", 31),
            person(12,"L","Ladf", 32),
            person(13,"M","Madf", 33),
            person(14,"N","Nadf", 34),
            person(15,"O","O", 35),
            person(16,"P","P", 36),
            person(17,"Q","Q", 37),
            person(18,"R","R", 38),
            person(19,"S","S", 39),
            person(20,"T","T", 40),
            person(21,"U","U", 41),
            person(22,"V","V", 42),
            person(23,"W","W", 43),
            person(24,"X","X", 44),
            person(25,"Y","Y", 45),
            person(26,"Z","Z", 46)
        )
    }
}