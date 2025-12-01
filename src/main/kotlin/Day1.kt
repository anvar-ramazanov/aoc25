import java.lang.Math.floorDiv

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

            val delta = if (direction == 'R') steps else -steps
            val next = current + delta

            val crossings = when {
                delta > 0 -> floorDiv(next, 100) - floorDiv(current, 100)
                delta < 0 -> floorDiv(current - 1, 100) - floorDiv(next - 1, 100)
                else -> 0
            }

            answer += crossings
            current = next.mod(100)
        }

        return answer
    }
}
