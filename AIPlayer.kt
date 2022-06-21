import kotlin.random.Random

private var AIPlayerCount = 0
class AIPlayer: Player() {
    private val AIPlayerName = ('A' + AIPlayerCount).toString()

    init {
        AIPlayerCount++
    }

    override fun nameSelf() {
        name = "AIPlayer $AIPlayerName"
    }

    override fun decideExchange() = Random.Default.nextBoolean()

    override fun chooseExchangee(otherPlayers: List<Player>) =
        otherPlayers[Random.Default.nextInt(otherPlayers.size)]


    override fun showCard(): Card {
        val card = hand.get(Random.Default.nextInt(hand.size))
        hand.remove(card)
        return card
    }
}