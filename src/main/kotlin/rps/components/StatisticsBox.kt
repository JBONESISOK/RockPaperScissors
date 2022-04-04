package rps.components

import react.FC
import react.Props
import react.dom.div
import react.dom.p
import react.functionComponent

external interface StatisticsProps : Props {
    var wins: Int
    var losses: Int
    var ties: Int
}

val statisticsBox: FC<StatisticsProps> = functionComponent { props ->
    div {
        p {
            +"Wins: ${props.wins}"
        }

        p {
            +"Losses: ${props.losses}"
        }

        p {
            +"Ties: ${props.ties}"
        }
    }
}

