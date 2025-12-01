class Day1: Task {
    override fun solve_part1(): Any {
        val input = readInput("Day1")

        var current = 50
        var answer = 0

        for (i in input) {
            val direction = i.first()
            val steps = i.substring(1).toInt()
            current = when (direction) {
                'R' -> (current + steps).mod(100)
                else -> (current - steps).mod(100)
            }
            if (current == 0) answer++
        }

        return answer
    }

    override fun solve_part2(): Any {
        val input = readInput("Day1")

        var current = 50
        var answer = 0

        for (i in input) {
            val direction = i.first()
            val steps = i.substring(1).toInt()

            for (j in 1..steps) {
                current = when (direction) {
                    'R' -> (current + 1)
                    else -> (current - 1)
                }
                current = current.mod(100)
                if (current == 0) {
                    answer++
                }
            }
        }

        return answer
    }
}
