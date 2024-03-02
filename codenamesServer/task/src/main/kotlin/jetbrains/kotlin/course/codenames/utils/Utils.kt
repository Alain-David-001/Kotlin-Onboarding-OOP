package jetbrains.kotlin.course.codenames.utils

import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun interface KeyCardGenerator {
    fun generateData(): List<KeyCardCell>
}

object Utils {
    private const val N = 5
    const val TOTAL_NUMBER = N * N
    const val PINK_CARDS_NUMBER = 8
    const val VIOLET_CARDS_NUMBER = 9
    const val GRAY_CARDS_NUMBER = 7
    const val BLACK_CARDS_NUMBER = 1

    init {
        require(TOTAL_NUMBER == PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER) {
            IllegalArgumentException("The numbers don't match")
        }
    }

    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()

    val uniqueKeyCardGenerator: KeyCardGenerator = KeyCardGenerator {
        var list: List<KeyCardCell>
        do {
            list = KeyCardType.values().flatMap { key ->
                List(key.number) { KeyCardCell(key) }
            }.shuffled()
        } while (list in previousAttempts)
        previousAttempts.add(list)
        list
    }


}