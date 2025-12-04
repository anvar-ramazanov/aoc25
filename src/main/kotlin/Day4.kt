class Day4 : Task {
    val directions = listOf(
        0 to 1, 0 to -1, 1 to 0, -1 to 0,
        1 to 1, 1 to -1, -1 to 1, -1 to -1
    )

    override fun solve_part1(): Any {
        val grid = readInput("Day4").map { it.toCharArray() }
        return grid.indices.sumOf { i ->
            grid[i].indices.count { j ->
                grid[i][j] == '@' && grid.getRollsCount(i, j) < 4
            }
        }
    }

    override fun solve_part2(): Any {
        val grid = readInput("Day4").map { it.toCharArray() }

        return generateSequence {
            grid.indices.sumOf { i ->
                grid[i].indices.count { j ->
                    (grid[i][j] == '@' && grid.getRollsCount(i, j) < 4).also { shouldMutate ->
                        if (shouldMutate) grid[i][j] = 'X'
                    }
                }
            }.takeIf { it > 0 }
        }.sum()
    }

    private fun List<CharArray>.getRollsCount(i: Int, j: Int): Int =
        directions.count { (di, dj) ->
            getOrNull(i + di)?.getOrNull(j + dj) == '@'
        }
}