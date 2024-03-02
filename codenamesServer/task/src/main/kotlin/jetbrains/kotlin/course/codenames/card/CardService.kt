package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size >= Utils.TOTAL_NUMBER) {
            "The words list must have a size greater than or equal to ${Utils.TOTAL_NUMBER}"
        }
        words = words.shuffled()
        val list = words.take(Utils.TOTAL_NUMBER).map { key-> Card(WordCardData(key),CardState.Front) }
        words = words.drop(Utils.TOTAL_NUMBER)
        return list
    }
}
