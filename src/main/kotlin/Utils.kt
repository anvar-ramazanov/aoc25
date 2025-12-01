import kotlin.io.path.Path
import kotlin.io.path.readText

fun readInput(name: String) = Path("src/main/kotlin/$name.txt").readText().trim().lines()