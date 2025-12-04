class Day4 : Task {
    val directions = listOf(
        0 to 1, 0 to -1, 1 to 0, -1 to 0,
        1 to 1, 1 to -1, -1 to 1, -1 to -1
    )

    override fun solve_part1(): Any {
        val input = readInput("Day4").map { it.toCharArray() }
        return input.indices.sumOf { i ->
            input[i].indices.count { j ->
                input[i][j] == '@' && getRolls(input, i, j, directions) < 4
            }
        }
    }

    override fun solve_part2(): Any {
        val input = readInput("Day4").map { it.toCharArray() }
        var answer = 0
        while (true) {
            var mutationsPerRun = 0
            for (i in input.indices) {
                for (j in input[i].indices) {
                    if (input[i][j] == '@' && getRolls(input, i, j, directions) < 4) {
                        mutationsPerRun++
                        input[i][j] = 'X'
                    }
                }
            }
            if (mutationsPerRun == 0) break
            answer += mutationsPerRun
        }

        return answer
    }

    private fun getRolls(
        input: List<CharArray>,
        i: Int,
        j: Int,
        directions: List<Pair<Int, Int>>
    ): Int {
        return directions.count { (di, dj) ->
            val newI = i + di
            val newJ = j + dj
            newI in input.indices &&
                    newJ in input[0].indices &&
                    input[newI][newJ] == '@'
        }
    }
}