class Day4 : Task {
    override fun solve_part1(): Any {
        val input = readInput("Day4")
        val directions = listOf(
            Pair(0, 1),
            Pair(0, -1),
            Pair(1, 0),
            Pair(-1, 0),
            Pair(1, 1),
            Pair(1, -1),
            Pair(-1, 1),
            Pair(-1, -1)
        )

        var answer = 0
        for ((i, line) in input.withIndex()) {
            for ((j, cur) in line.withIndex()) {
               if (cur == '@') {
                   val rolls = getRolls(input, i, j, directions)
                   if (rolls < 4) answer++
               }
            }
        }

        return answer
    }

    private fun getRolls(
        input: List<String>,
        i: Int,
        j: Int,
        directions: List<Pair<Int, Int>>
    ): Int {
        var rolls = 0

        for (dir in directions) {
            val newI = (i + dir.first)
            val newJ = (j + dir.second)
            if (newI >= 0 && newI < input.size && newJ >= 0 && newJ < input[0].length) {
                if (input[newI][newJ] == '@') rolls++
            }
        }

        return rolls
    }

    override fun solve_part2(): Any {
        return 0
    }
}