class Day2 : Task {
    override fun solve_part1(): Any {
        val ranges = parseRanges(readInput("Day2"))
        return solve(ranges, Regex("^(.+)\\1$"))
    }

    override fun solve_part2(): Any {
        val ranges = parseRanges(readInput("Day2"))
        return solve(ranges, Regex("^(.+)\\1+$"))
    }

    private fun solve(ranges: List<Range>, pattern: Regex): Long {
        return ranges.sumOf { range ->
            (range.min..range.max)
                .filter { it.toString().matches(pattern) }
                .sum()
        }
    }

    fun parseRanges(input: List<String>): List<Range> =  input
        .first()
        .split(",")
        .map {
            it.split("-").let { str -> Range(str[0].toLong(), str[1].toLong())}
        }

    data class Range(val min: Long, val max: Long)
}