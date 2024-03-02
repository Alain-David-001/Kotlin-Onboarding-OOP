package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        val teamsStorage : MutableMap<Identifier, Team> = mutableMapOf()
    }

    private val identifierFactory : IdentifierFactory = IdentifierFactory()
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams : MutableList<Team> = mutableListOf()
        for (i in 1..teamsNumber){
            val id = identifierFactory.uniqueIdentifier()
            val team = Team(id,0)
            teamsStorage[id] = team
            teams.add(team)
        }
        return teams
    }
}
