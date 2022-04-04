package rps.components

import RPSStyles
import kotlinx.html.js.onClickFunction
import react.RBuilder
import rps.GameHandler
import rps.RPS
import rps.displayResult
import rps.playGame
import styled.css
import styled.styledButton
import styled.styledImg
import website.getImage
fun RBuilder.playerButton(hand: RPS, gameHandler: GameHandler){
    styledButton {
        css {
            +RPSStyles.playerButton
        }
        attrs.name = hand.name
        styledImg {
            css {
                +RPSStyles.img
            }
            attrs.src = getImage(hand)
        }
        attrs.onClickFunction = {
            val result = playGame(hand)
            displayResult(result)
            gameHandler.updateStats(result)
        }
    }
}

