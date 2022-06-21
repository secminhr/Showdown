class Card(val rank: Rank, val suit: Suit): Comparable<Card> {
    enum class Rank {
        Two, Three, Four, Five, Six, Seven,
        Eight, Nine, Ten, J, Q, K, A
    }
    enum class Suit { Club, Diamond, Heart, Spade }

    override operator fun compareTo(other: Card): Int =
        if (rank != other.rank) rank.compareTo(other.rank) else suit.compareTo(other.suit)

    override fun toString() = "$rank of ${suit}s"
}
