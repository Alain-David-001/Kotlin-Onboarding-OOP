package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private fun generateCards(): List<Card> = words.shuffled().chunked(WORDS_IN_CARD).take(cardsAmount)
        .map { list -> Card(identifierFactory.uniqueIdentifier(), list.map { Word(it) }) }


    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

//    {
//        val list : MutableList<Word> = mutableListOf()
//        this.mapTo(list) { Word(it) }
//        val wordList : List<Word> = list
//        return wordList
//    }

    fun getCardByIndex(index: Int): Card = cards.getOrNull(index) ?: error("There's no card with such index")

    companion object {
        private const val WORDS_IN_CARD: Int = 4
        val cardsAmount: Int = words.size / WORDS_IN_CARD

    }

    private val identifierFactory: IdentifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()
}
