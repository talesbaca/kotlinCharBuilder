package main

import model.Race
import strategy.CharacterCreationStrategy
import strategy.DefaultCharacterCreationStrategy

fun main() {
    val races = mapOf(
        "Human" to Race("Human", mapOf("Strength" to 1, "Dexterity" to 1, "Constitution" to 1, "Intelligence" to 1, "Wisdom" to 1, "Charisma" to 1)),
        "Elf" to Race("Elf", mapOf("Dexterity" to 2)),
        "Dwarf" to Race("Dwarf", mapOf("Constitution" to 2)),
        "Halfling" to Race("Halfling", mapOf("Dexterity" to 2))
    )

    println("Selecione a raça:")
    races.keys.forEach { println(it) }

    val selectedRace = readLine()?.capitalize() ?: ""

    if (!races.containsKey(selectedRace)) {
        println("Raça inválida.")
        return
    }

    val race = races[selectedRace]!!
    val strategy: CharacterCreationStrategy = DefaultCharacterCreationStrategy()
    val character = strategy.createCharacter(race)

    println("Resultado final com bônus de raça aplicado:")
    character.attributes.forEach { (attr, value) ->
        println("$attr: $value")
    }

    val healthPoints = character.calculateHealthPoints()
    println("Pontos de vida: $healthPoints")
}