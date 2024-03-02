package jetbrains.kotlin.course.alias.util
typealias Identifier = Int

class IdentifierFactory {
    fun uniqueIdentifier(): Identifier = counter++
    private var counter: Identifier = 0
}
