package creator

import model.Character
import model.Race

class DefaultCharacterCreator : CharacterCreator {
    override fun createCharacter(race: Race): Character {
        val attributes = mutableMapOf(
            "Força" to 8,
            "Destreza" to 8,
            "Constituição" to 8,
            "Inteligência" to 8,
            "Sabedoria" to 8,
            "Carisma" to 8
        )

        val character = Character(attributes, race)
        character.applyRaceBonuses()

        val points = 27
        character.distributePoints(points)

        return character
    }
}