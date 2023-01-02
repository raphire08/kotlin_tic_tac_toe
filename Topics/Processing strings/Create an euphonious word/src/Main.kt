const val vowels = "aeiouy"

fun main() {
    val input = readln()
    var minNum = 0
    var count = 0
    var flag = true
    while(flag) {
        val elem = input.substring(count, count+3)
        val discordant = isDiscordant(elem)
        if(discordant) {
            minNum++
            count += 2
        } else {
            count++
        }
        if(count > input.length - 3) {
            flag = false
        }
    }
    println(minNum)
}

fun isDiscordant(a: String): Boolean {
    if (a[0] in vowels) {
        if(a[1] in vowels && a[2] in vowels) {
            return true
        }
        return false
    } else {
        if(a[1] !in vowels && a[2] !in vowels) {
            return true
        }
        return false
    }
}