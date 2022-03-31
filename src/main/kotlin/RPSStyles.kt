import kotlinx.css.*
import styled.StyleSheet

object RPSStyles : StyleSheet("RPSStyles", isStatic = true) {
    val img by css {
        width = 100.px
        height = 100.px
    }
    val playerButton by css {
        margin(10.px)
        backgroundColor = Color.aqua
    }

} 
