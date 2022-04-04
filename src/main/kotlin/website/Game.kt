package website

import kotlinx.html.id
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.div
import react.dom.h1
import react.dom.h2
import rps.GameHandler
import rps.RPS
import rps.components.playerButton
import rps.components.rpsHand
import rps.components.statisticsBox


external fun prompt(msg: String)
external interface PlayerProps : Props {
    var name: String
    var wins: Int
    var losses: Int
    var ties: Int
}


data class PlayerState(val name: String, val wins: Int, val losses: Int, val ties: Int) : State

class Game(props: PlayerProps) : RComponent<PlayerProps, PlayerState>(props) {
    init {
        state = PlayerState(props.name, props.wins, props.losses, props.ties)
    }

    override fun RBuilder.render() {
        div {
            h1 {
                +"Rock Paper Scissors"
            }
            h2 {
                attrs.id = "result_text"
            }
            statisticsBox {
                attrs.wins = state.wins
                attrs.losses = state.losses
                attrs.ties = state.ties
            }
        }
        div {
            rpsHand(state.name, "player")
            div {
                attrs.id = "player_buttons"
                val gameHandler = object : GameHandler {
                    override fun updateStats(result: Boolean?) {
                        when (result) {
                            true -> setState(PlayerState(state.name, state.wins + 1, state.losses, state.ties))
                            false -> setState(PlayerState(state.name, state.wins, state.losses + 1, state.ties))
                            else -> setState(PlayerState(state.name, state.wins, state.losses, state.ties + 1))
                        }
                    }
                }
                playerButton(RPS.ROCK, gameHandler)
                playerButton(RPS.PAPER, gameHandler)
                playerButton(RPS.SCISSORS, gameHandler)
            }
        }
        rpsHand("Computer", "computer")
    }
}
