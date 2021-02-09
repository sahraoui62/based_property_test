package com.softwarecs.demo.model

import java.time.LocalDate

class User(val firstname: String, val lastname: String, val birthday: LocalDate, val friends: Set<User>) {

    fun isBirthday(date: LocalDate): Boolean = date.dayOfMonth == birthday.dayOfMonth && date.month == birthday.month

    // utilité des générateurs quand je vérifie que les amis de mes amis sont bien tous présents
    fun getFriendsOfFriends(): Set<User> = friends.flatMap { it.friends }.toSet()

    // méthode pas bonne si 1 contient une majuscule et pas l'autre
    // même famille que lui même renvoie toujours ok
    fun areFromSameFamily(user: User): Boolean = user.lastname == lastname

}