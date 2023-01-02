fun main() {
    val input = readln()
    val lucky = input[0].toInt() + input[1].toInt() + input[2].toInt() == input[3].toInt() + input[4].toInt() + input[5].toInt()
    if (lucky) println("Lucky") else println("Regular")
}
