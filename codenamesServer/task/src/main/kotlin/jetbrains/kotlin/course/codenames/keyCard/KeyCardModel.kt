package jetbrains.kotlin.course.codenames.keyCard

import jetbrains.kotlin.course.codenames.utils.Utils

@JvmInline
value class KeyCardCell(val type: KeyCardType)

enum class KeyCardType (val number: Int) {
    Pink(Utils.PINK_CARDS_NUMBER),
    Violet(Utils.VIOLET_CARDS_NUMBER),
    Gray(Utils.GRAY_CARDS_NUMBER),
    Black(Utils.BLACK_CARDS_NUMBER)
}

data class KeyCard(val cells:List<KeyCardCell> = Utils.uniqueKeyCardGenerator.generateData() )