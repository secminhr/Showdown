class Game {
    private val deck = Deck()
    private lateinit var players: Array<Player>

    fun start() {
        setupPlayers()
        deck.shuffle()
        drawStage()
        for (i in 1..13) {
            round(i)
        }
        val winner = players.maxWithOrNull { p1, p2 -> p1.point - p2.point }!!
        println("Winner is $winner!")
    }

    private fun setupPlayers() {
        val humanPlayerNumber = readInt("Human player number: ", 1..4)
        players = Array(4) { index ->
            if (index < humanPlayerNumber) HumanPlayer() else AIPlayer()
        }
        for (player in players) player.nameSelf()
        players.shuffle()
    }

    private fun drawStage() {
        while (!deck.isEmpty) {
            for (player in players) {
                player.draw(deck)
            }
        }
    }

    private fun round(number: Int) {
        println("Round $number started")
        val cardsShown = mutableListOf<Card?>()
        for (player in players) {
            cardsShown.add(player.takeTurn(otherPlayers = players.filter { player != it }))
        }

        println("Showdown!")
        for ((index, card) in cardsShown.withIndex()) {
            println("${players[index]}'s card: ${card ?: "none"}")
        }

        val maxCard = cardsShown.filterNotNull().maxOrNull()!!
        print("Winner for the round: ")
        val roundWinner = players[cardsShown.indexOf(maxCard)]
        println("$roundWinner with its $maxCard")
        roundWinner.gainPoint()

        println()
    }
}