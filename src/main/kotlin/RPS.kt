import kotlinx.browser.document
import org.w3c.dom.HTMLImageElement

enum class RPS {
    ROCK, PAPER, SCISSORS;
}

fun displayResult(result: Boolean?) {
    val resultText = document.getElementById("result_text")!!
    when (result) {
        true -> {
            resultText.textContent = "You won"
        }
        false -> {
            resultText.textContent = "You lost"
        }
        else -> {
            resultText.textContent = "You tied"
        }
    }
}

fun getImage(hand: RPS): String {
    return when (hand) {
        RPS.ROCK -> {
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.explicit.bing.net%2Fth%3Fid%3DOIP.r8R2Zmxr-n-F4o8ySqjZLQHaF3%26pid%3DApi&f=1"
        }
        RPS.PAPER -> {
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.jyOHIXJgIZNbGxepk2PCqAHaIH%26pid%3DApi&f=1"
        }

        RPS.SCISSORS -> {
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.5MeL31GQVEk_VFWwSrVKfQHaE7%26pid%3DApi&f=1"
        }
    }
}

fun playGame(player: RPS): Boolean? {
    val computerImage = document.getElementById("computer_hand") as HTMLImageElement
    val playerImage = document.getElementById("player_hand") as HTMLImageElement
    val computerHand = RPS.values().random()
    computerImage.src = getImage(computerHand)
    playerImage.src = getImage(player)
    return when (computerHand) {
        RPS.ROCK -> {
            when (player) {
                RPS.ROCK -> null
                RPS.PAPER -> true
                RPS.SCISSORS -> false
            }
        }
        RPS.PAPER -> {
            when (player) {
                RPS.ROCK -> false
                RPS.PAPER -> null
                RPS.SCISSORS -> true
            }
        }

        RPS.SCISSORS -> {
            when (player) {
                RPS.ROCK -> true
                RPS.SCISSORS -> null
                RPS.PAPER -> false
            }
        }
    }

}
