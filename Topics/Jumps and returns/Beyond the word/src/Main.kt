fun main() {
    val alpha = "abcdefghijklmnopqrstuvwxyz"
    val alphaList: MutableList<String>  = alpha.split("").toMutableList()
    val input = readln()
    for (i in input) {
        alphaList.remove(i.toString())
    }
    println(alphaList.joinToString(""))
}
