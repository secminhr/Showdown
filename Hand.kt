private const val MAX_HAND_SIZE = 13
class Hand {
    private val cards = mutableListOf<Card>()
    val size: Int
        get() = cards.size
    val isEmpty: Boolean
        get() = cards.isEmpty()

    fun get(index: Int): Card = cards[index]
    fun add(card: Card) {
        if (cards.size >= MAX_HAND_SIZE) {
            throw IllegalStateException("Hand can't contain more than 13 cards")
        }
        cards.add(card)
    }

    fun remove(card: Card) {
        cards.remove(card)
    }

    operator fun iterator(): Iterator<IndexedValue<Card>> = cards.withIndex().iterator()
}