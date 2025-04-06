package noose.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaPracticeApplication

fun main(args: Array<String>) {
    runApplication<KafkaPracticeApplication>(*args)
}
