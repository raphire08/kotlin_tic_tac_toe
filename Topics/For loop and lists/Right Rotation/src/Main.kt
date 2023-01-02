fun main() {
    val length = readln().toInt()
    val list: MutableList<Int> = mutableListOf()
    for (i in 0 until length) {
        list.add(readln().toInt())
    }
    var shifts = readln().toInt()
    shifts %= length
    val shiftedList = list.subList(length - shifts, length) + list.subList(0, length-shifts)
    println(shiftedList.joinToString(" "))
}
