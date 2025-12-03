class Day3 : Task {
    override fun solve_part1(): Any {
        return readInput("Day3")
            .sumOf { getJoltage(it) }
    }

    private fun getJoltage(line: String): Int {
        val len = line.length

        var left = line[len - 2]
        var leftInd = len - 2

        for (i in len -2 downTo 0) {
            if (line[i] >= left) {
                left = line[i]
                leftInd = i
            }
        }

        var right = line[leftInd + 1]
        for (i in leftInd + 1 until len) {
            if (line[i] >= right) {
                right = line[i]
            }
        }

        return (left + "" + right).toInt()
    }

    override fun solve_part2(): Any {
        return 0
    }

}