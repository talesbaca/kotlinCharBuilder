package strategy

import model.Character
import model.Race

class DefaultCharacterCreationStrategy : CharacterCreationStrategy {
    override fun createCharacter(race: Race): Character {
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

        val points = 27
        character.distributePoints(points)

        return character
    }
}