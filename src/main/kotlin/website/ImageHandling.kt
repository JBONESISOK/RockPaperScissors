package website

import kotlinx.browser.document
import org.w3c.dom.HTMLImageElement
import rps.RPS
fun getImage(hand: RPS): String {
    return when (hand) {
        RPS.ROCK -> {
            "rock.jpg"
        }
        RPS.PAPER -> {
            "paper.jpg"
        }

        RPS.SCISSORS -> {
            "scissors.jpg"
        }
    }
}

fun changeImages(player: RPS, computerHand: RPS) {
    val computerImage = document.getElementById("computer_hand") as HTMLImageElement
    val playerImage = document.getElementById("player_hand") as HTMLImageElement
    computerImage.src = getImage(computerHand)
    playerImage.src = getImage(player)
}

