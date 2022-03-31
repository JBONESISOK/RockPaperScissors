import kotlinx.html.id
import react.RBuilder
import react.dom.div
import react.dom.p
import styled.css
import styled.styledImg

fun RBuilder.rpsHand(name: String, id: String) {
    div {
        p {
            +"$name's hand"
        }
        styledImg {
            css {
                +RPSStyles.img
            }
            attrs.id = id + "_hand"
        }
    }
}