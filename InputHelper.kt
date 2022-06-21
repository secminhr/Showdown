internal fun readString(prompt: String): String {
    var input: String? = null
    while (input == null) {
        print(prompt)
        input = readLine()
    }
    return input
}

internal fun readInt(prompt: String, range: IntRange): Int {
    var input: Int? = null
    while (input == null || input !in range) input = readString(prompt).toIntOrNull()
    return input
}

internal fun readYN(prompt: String): Boolean {
    while (true) {
        when(readString(prompt)) {
            "y", "Y" -> return true
            "n", "N" -> return false
        }
    }
}