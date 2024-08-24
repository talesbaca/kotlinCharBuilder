package strategy

import model.Character
import model.Race

interface CharacterCreationStrategy {
    fun createCharacter(race: Race): Character
}