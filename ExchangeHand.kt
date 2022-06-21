class ExchangeHand(private val playerA: Player, private val playerB: Player) {
    private var remainingRound = 3
    fun decreaseRound() {
        if (remainingRound == 0) return

        remainingRound--
        if (remainingRound == 0) {
            println("3 round has passed, exchange back")
            giveBack()
        }
    }

    private fun giveBack() {
        playerA.exchangeHand(playerB) //exchange back
    }
}