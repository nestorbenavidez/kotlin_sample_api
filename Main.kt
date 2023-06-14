import io.ktor.application.*
import io.ktor.features.ContentTransformationException
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.post
import io.ktor.routing.routing

data class NumbersRequest(val numbers: Set<Int>)

fun Application.module() {
    install(StatusPages) {
        exception<ContentTransformationException> { cause ->
            call.respond(HttpStatusCode.BadRequest, "Invalid request format: ${cause.message}")
        }
    }

    install(ContentNegotiation) {
        jackson {
            // Configure Jackson serialization if needed
        }
    }

    routing {
        post("/numbers") {
            val request = call.receive<NumbersRequest>()
            val numbers = request.numbers.toList()

            if (numbers.size < 2) {
                call.respond(HttpStatusCode.BadRequest, "Set must contain at least two numbers.")
            } else {
                val (largest, secondLargest) = findTwoLargestNumbers(numbers)
                call.respond(mapOf("largest" to largest, "secondLargest" to secondLargest))
            }
        }
    }
}

fun findTwoLargestNumbers(numbers: List<Int>): Pair<Int, Int> {
    val sortedNumbers = numbers.sorted()
    val largest = sortedNumbers.last()
    val secondLargest = sortedNumbers[sortedNumbers.size - 2]
    return Pair(largest, secondLargest)
}

