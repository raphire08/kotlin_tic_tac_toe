package tictactoe


fun main() {
    val input = "         "
    printGrid(input)
    handleMove(input, true)
}

fun checkSeries(series: MutableList<Char>) : Boolean {
    val first = series.first()
    return if(first == 'X' || first == 'O') {
        series[1] == first && series[2] == first
    } else {
        false
    }
}

fun checkPosition(n: Int): Boolean {
    return n in 1..3
}

fun getInputPosition(x: Int, y: Int) : Int {
    return 3 * (x - 1) + (y - 1)
}

fun printGrid(input: String) {
    println("----------")
    println("| ${input[0]} ${input[1]} ${input[2]} |")
    println("| ${input[3]} ${input[4]} ${input[5]} |")
    println("| ${input[6]} ${input[7]} ${input[8]} |")
    println("----------")
}

fun handleMove(input: String, isFirst: Boolean) {
    val move = readln().split(" ")
    val rowPosition = move[0].toIntOrNull()
    val columnPosition = move[1].toIntOrNull()
    if(rowPosition != null && columnPosition != null) {
        if(checkPosition(rowPosition) && checkPosition(columnPosition)) {
            val inputPosition = getInputPosition(rowPosition, columnPosition)
            val newInput: String
            if(input[inputPosition] == ' ') {
                newInput = if(isFirst) {
                    "${input.substring(0, inputPosition)}X${input.substring(inputPosition + 1)}"
                } else {
                    "${input.substring(0, inputPosition)}O${input.substring(inputPosition + 1)}"
                }
                val play = continueGame(newInput)
                if(play) {
                    printGrid(newInput)
                    handleMove(newInput, !isFirst)
                }
            } else {
                println("This cell is occupied! Choose another one!")
                handleMove(input, isFirst)
            }
        } else {
            println("Coordinates should be from 1 to 3!")
            handleMove(input, isFirst)
        }
    } else {
        println("You should enter numbers!")
        handleMove(input, isFirst)
    }
}

fun continueGame(input: String): Boolean {
     var xCount = 0
     var oCount = 0
     var remCount = 0
    var winner = 'X'
    var winCount = 0
    val series: MutableList<MutableList<Char>> = mutableListOf()
     for (i in input.indices) {
         if (input[i] == 'X') {
             xCount++
         } else if (input[i] == 'O') {
             oCount++
         } else {
             remCount++
         }
          when(i) {
              0 -> {
                 series.add(mutableListOf(input[0], input[1], input[2]))
                 series.add(mutableListOf(input[0], input[3], input[6]))
                 series.add(mutableListOf(input[0], input[4], input[8]))
             }
              1 -> {
                  series.add(mutableListOf(input[1], input[4], input[7]))
              }
              2 -> {
                  series.add(mutableListOf(input[2], input[4], input[6]))
                  series.add(mutableListOf(input[2], input[5], input[8]))
              }
              3 -> {
                  series.add(mutableListOf(input[3], input[4], input[5]))
              }
              6 -> {
                  series.add(mutableListOf(input[6], input[7], input[8]))
              }
          }
     }
     if ((xCount - oCount) >= 2 || (xCount - oCount) <= -2) {
         println("Impossible")
         return false
     } else {
         for (j in series) {
             val hasMatch = checkSeries(j)
             if(hasMatch) {
                 winCount++
                 winner = j.first()
             }
         }
         return if (winCount >= 2) {
             println("Impossible")
             false
         } else if (winCount == 1) {
             printGrid(input)
             println("$winner wins")
             false
         } else if (winCount == 0 && remCount > 0) {
             println("Game not finished")
             true
         } else {
             println("Draw")
             false
         }
     }
}


