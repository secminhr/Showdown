abstract class Player {
    protected lateinit var name: String
    protected var hand: Hand = Hand()
    private var exchangeHand: ExchangeHand? = null
    private var hasExchanged = false
    var point: Int = 0
        private set

    abstract fun nameSelf()
    protected abstract fun decideExchange(): Boolean
    protected abstract fun chooseExchangee(otherPlayers: List<Player>): Player
    protected abstract fun showCard(): Card

    fun draw(deck: Deck) {
        hand.add(deck.draw())
    }

    fun takeTurn(otherPlayers: List<Player>): Card? {
        println("$this's turn")
        exchangeHand?.decreaseRound()
        if (!hasExchanged && decideExchange()) {
            val exchangee = chooseExchangee(otherPlayers)
            println("$this decide to exchange with $exchangee")
            exchangeHand(exchangee)
            exchangeHand = ExchangeHand(this, exchangee)
            hasExchanged = true
        }
        return if (hand.isEmpty) {
            println("You have no card to show. Skipped")
            null
        } else showCard()
    }

    fun exchangeHand(other: Player) {
        val temp = hand
        hand = other.hand
        other.hand = temp
        println("Hands of $this and $other are exchanged")
    }

    fun gainPoint() {
        point++
    }

    override fun toString() = name
}