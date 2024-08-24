package main

import model.*
import creator.CharacterCreator
import creator.DefaultCharacterCreator

fun main() {
    val races = mapOf(
        "Humano" to Human(),
        "Elfo" to Elf(),
        "Anão" to Dwarf(),
        "Halfling" to Halfling()
    )

    println("Selecione a raça:")
    races.keys.forEach { println(it) }

    val selectedRace = readLine()?.capitalize() ?: ""

    if (!races.containsKey(selectedRace)) {
        println("Raça inválida.")
        return
    }

    val race = races[selectedRace]!!
    val creator: CharacterCreator = DefaultCharacterCreator()
    val character = creator.createCharacter(race)

    println("Atributos com aplicação de bônus de raça:")
    character.attributes.forEach { (attr, value) ->
        println("$attr: $value")
    }

    val healthPoints = character.calculateHealthPoints()
    println("Pontos de vida: $healthPoints")
}