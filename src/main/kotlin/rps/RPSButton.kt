package rps

import RPSStyles
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.css
import styled.styledButton
import styled.styledImg
import website.getImage

fun RBuilder.playerButton(hand: RPS) {
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
            displayResult(playGame(hand))
        }
    }
}

