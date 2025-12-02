class Day2 : Task {
    override fun solve_part1(): Any {
        val input = readInput("Day2")

        val ranges = input
            .first()
            .split(",")
            .map { it.split("-").let { Range(it[0].toLong(), it[1].toLong())} }

        var answer: Long = 0

        for (range in ranges) {
            for (i in range.min..range.max) {
                val str = i.toString()
                if (str.length % 2 == 0) {
                    val firstHalf = str.substring(0, str.length / 2)
                    val secondHalf = str.substring(str.length / 2)
                    if (firstHalf == secondHalf) {
                        answer += i
                    }
                }
            }
        }

        return answer
    }

    override fun solve_part2(): Any {
        return 0
    }
}


data class Range(val min: Long, val max: Long)