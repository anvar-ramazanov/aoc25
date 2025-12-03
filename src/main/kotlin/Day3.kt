class Day3 : Task {
    override fun solve_part1(): Any {
        return readInput("Day3")
            .sumOf { getJoltage(it, 2) }
    }

    override fun solve_part2(): Any {
        return readInput("Day3")
            .sumOf { getJoltage(it, 12) }
    }

    private fun getJoltage(line: String, maxSlots: Int): Long {
        val startIndex = line.length - maxSlots

        val leftIndex = (startIndex downTo 0)
            .reduce { acc, i -> if (line[i] >= line[acc]) i else acc }

        val result = buildList {
            add(line[leftIndex])
            var prevIndex = leftIndex

            repeat(maxSlots - 1) {
                val remainingSlots = maxSlots - size
                val searchRange = (prevIndex + 1)..(line.length - remainingSlots)

                val maxIndex = searchRange
                    .reduce { acc, i -> if (line[i] > line[acc]) i else acc }

                add(line[maxIndex])
                prevIndex = maxIndex
            }
        }

        return result.joinToString("").toLong()
    }
}