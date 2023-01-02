fun main() {
    val row = mutableListOf("1", "2", "3", "4", "5")
    val column = mutableListOf("1", "2", "3", "4", "5")
    for (i in 1..3) {
        val input = readln().split(" ")
        row.remove(input[0])
        column.remove(input[1])
    }
    println(row.joinToString(" "))
    println(column.joinToString(" "))
}
