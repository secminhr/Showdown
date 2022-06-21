class Deck {
    private val cards = mutableListOf<Card>()
    val isEmpty: Boolean
        get() = cards.isEmpty()

    init {
        for (rank in Card.Rank.values()) {
            for (suit in Card.Suit.values()) {
                cards.add(Card(rank, suit))
            }
        }
    }

    fun shuffle() = cards.shuffle()
    fun draw(): Card = cards.removeAt(0)

}