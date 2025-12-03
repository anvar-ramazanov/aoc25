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
        return readInput("Day3")
            .sumOf { getJoltage2(it, 12) }
    }

    private fun getJoltage2(line: String, l: Int): Long {
        val accumulator = mutableListOf<Char>()
        val len = line.length


        var left = line[len - l]
        var prevInd = len - l

        for (i in len - l downTo 0) {
            if (line[i] >= left) {
               left = line[i]
                prevInd = i
            }
        }
        accumulator.add(left)

        while (accumulator.size < l) {
            var cur = line[prevInd + 1]
            var curInd = prevInd + 1
            for (i in prevInd + 1 .. len - (l - accumulator.size)) {
                if (line[i] > cur) {
                    cur = line[i]
                    curInd = i
                }
            }
            accumulator.add(cur)
            prevInd = curInd
        }

        return accumulator.joinToString("").toLong()
    }
}