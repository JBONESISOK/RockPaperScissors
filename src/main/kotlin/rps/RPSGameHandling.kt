package rps

import kotlinx.browser.document
import website.changeImages

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

fun playGame(player: RPS): Boolean? {
    val computerHand = RPS.values().random()
    changeImages(player, computerHand)
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