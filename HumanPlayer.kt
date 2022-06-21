class HumanPlayer: Player() {
    override fun nameSelf() {
        name = readString("enter player name: ")
    }

    override fun decideExchange() = readYN("exchange with another player? (y|n) ")

    override fun chooseExchangee(otherPlayers: List<Player>): Player {
        println("Players:")
        for ((index, player) in otherPlayers.withIndex()) {
            println("$index: $player")
        }
        val index = readInt("You choose to exchange with (index): ", range = otherPlayers.indices)
        return otherPlayers[index]
    }

    override fun showCard(): Card {
        println("Your hand:")
        for ((index, card) in hand) {
            println("$index: $card")
        }
        val index = readInt("You choose to show (index): ", 0 until hand.size)
        val card = hand.get(index)
        hand.remove(card)
        return card
    }
}