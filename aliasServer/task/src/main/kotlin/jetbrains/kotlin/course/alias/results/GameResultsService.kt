package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object{
        val gameHistory : MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult): Unit {
        require(result.isNotEmpty()) {
            "Result cannot be empty"
        }
        require(result.all { it.id in TeamService.teamsStorage }) {
            "Not all team ids from the result are present in the TeamService.teamsStorage"
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}

//require(cards.size <= GameCard.MAX_NUMBER_OF_CARDS) { "The maximum number of cards is ${GameCard.MAX_NUMBER_OF_CARDS}" }