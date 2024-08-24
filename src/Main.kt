import model.Character
import model.Race
import java.util.*

fun main() {
    val races = mapOf(
        "Humano" to Race("Humano", mapOf("Strength" to 1, "Dexterity" to 1, "Constitution" to 1, "Intelligence" to 1, "Wisdom" to 1, "Charisma" to 1)),
        "Elfo" to Race("Elfo", mapOf("Dexterity" to 2)),
        "Anão" to Race("Anão", mapOf("Constitution" to 2)),
        "Halfling" to Race("Halfling", mapOf("Dexterity" to 2))
    )

    println("Escolha uma raça para seu personagem:")
    races.keys.forEach { println(it) }

    val selectedRace = readLine()?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        ?: ""

    if (!races.containsKey(selectedRace)) {
        println("Raça inválida")
        return
    }

    val race = races[selectedRace]!!
    val attributes = mutableMapOf(
        "Strength" to 8,
        "Dexterity" to 8,
        "Constitution" to 8,
        "Intelligence" to 8,
        "Wisdom" to 8,
        "Charisma" to 8
    )

    val character = Character(attributes, race)
    character.applyRaceBonuses()
    println("Resultado aplicando bonus de raça:")

    character.attributes.forEach { (attr, value) ->
        println("$attr: $value")
    }

    var points = 27
    character.distributePoints(points)

    println("Resultado final:")
    character.attributes.forEach { (attr, value) ->
        println("$attr: $value")
    }
}