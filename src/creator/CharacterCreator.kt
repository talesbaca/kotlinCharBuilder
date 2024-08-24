package creator

import model.Character
import model.Race

interface CharacterCreator {
    fun createCharacter(race: Race): Character
}