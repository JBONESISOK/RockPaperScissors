package website

import kotlinx.browser.document
import org.w3c.dom.HTMLImageElement
import rps.RPS

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

fun changeImages(player: RPS, computerHand: RPS) {
    val computerImage = document.getElementById("computer_hand") as HTMLImageElement
    val playerImage = document.getElementById("player_hand") as HTMLImageElement
    computerImage.src = getImage(computerHand)
    playerImage.src = getImage(player)
}


