package fiftyfifty

import fiftyfifty.Coin.Companion.HEAD
import fiftyfifty.Coin.Companion.TAIL
import kotlin.system.measureTimeMillis


fun main() {
    val coin = Coin()
    val NUMBER_OF_BET = 1_000_000

    val casino = Person("casino", 10000.0, 102.0, 100.0)
    val rohman = Person("rohman", 10000.0, 100.0, 102.0)

    val time = measureTimeMillis{
        (0 until NUMBER_OF_BET).forEach {
            val guess = (TAIL..HEAD).random()
            val flipResult = coin.flipResult()

            println(
                """
                New Game
                ${rohman.name} Guess   : ${guess}
                Flip Result    : ${flipResult}
            """.trimIndent()
            )

            if (guess == flipResult) {
                println("[ ${rohman.name} ]")
                rohman.win()
                casino.lose()
            } else {
                println("[ ${rohman.name} Lose ]")
                rohman.lose()
                casino.win()
            }

            println(
                """
                ${rohman.name}    Balance   : ${rohman.money}
                ${casino.name}  Balance     : ${casino.money}
                ==================================
                
            """.trimIndent()
            )
        }
    }

    println(
        """
                ++++++++++++++++++++++
                Final Result
                ${rohman.name} Balance              : ${rohman.money}
                ${casino.name} Balance              : ${casino.money}
                ${rohman.name} Win Probability      : ${rohman.getWinProbability(NUMBER_OF_BET)}%
                ${casino.name} Win Probability      : ${casino.getWinProbability(NUMBER_OF_BET)}%
                ++++++++++++++++++++++
        """.trimIndent()
    )

    println("Execution Time : ${(time.toDouble()/1000)}")

}
