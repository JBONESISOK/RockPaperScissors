package website

import kotlinx.html.id
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.div
import react.dom.h1
import react.dom.h2
import rps.RPS
import rps.playerButton
import rps.rpsHand

external fun prompt(msg: String)
external interface PlayerProps : Props {
    var name: String
}

data class PlayerState(val name: String) : State

class Game(props: PlayerProps) : RComponent<PlayerProps, PlayerState>(props) {
    init {
        state = PlayerState(props.name)
    }
    override fun RBuilder.render() {
        div {
            h1 {
                +"Rock Paper Scissors"
            }
            h2 {
                attrs.id = "result_text"
            }
        }
        div {
            rpsHand(state.name, "player")
            div {
                attrs.id = "player_buttons"
                playerButton(RPS.ROCK)
                playerButton(RPS.PAPER)
                playerButton(RPS.SCISSORS)
            }
        }
        rpsHand("Computer", "computer")
    }
}
