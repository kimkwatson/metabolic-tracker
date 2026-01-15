import kotlin.io.println

fun main() {
    val values = getValues() ?: return

    val (glucose, ketones) = values

    println("Glucose = " + glucose)
    println("Ketones = " + ketones)
    val ratio = calculateRatio(glucose, ketones)
    println("Ratio: $ratio")
    results(ratio)

    // create instance of MetabolicValues class
    val userValues = MetabolicValues(
        glucose = glucose,
        ketones = ketones
    )
}

fun getValues(): Pair<Int, Double>? {
    print("Enter Glucose: ")
    val glucose = readLine()?.toIntOrNull()

    if (glucose == null) {
        println("Invalid glucose input")
        return glucose
    }

    print("Enter Ketones: ")
    val ketones = readLine()?.toDoubleOrNull()

    if (ketones == null) {
        println("Invalid ketones input")
        return ketones
    }

    return Pair(glucose, ketones)
}

fun calculateRatio(glucose: Int, ketones: Double): Double {
    val ratio = glucose / ketones
    return ratio
}

fun results(ratio: Double) {

    val feedback = when {
        ratio > 80 -> "Glucose-burning mode"
        ratio >= 40 -> "Moderate ketosis"
        ratio < 40 -> "Deep ketosis"
        else -> "Invalid ratio"
    }

    println(feedback)
}