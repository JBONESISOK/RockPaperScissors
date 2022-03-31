import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render

fun main() {
    document.title = "Rock Paper Scissors"
    window.onload = {
        render(document.getElementById("root")) {
            child(Game::class) {
                attrs {
                    name = prompt("What is your name?").toString()
                }
            }
        }
    }
}