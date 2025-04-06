package noose.kafka.ui.message

import io.github.oshai.kotlinlogging.KotlinLogging
import noose.kafka.ui.shared.DEFAULT_TOPIC
import noose.kafka.ui.shared.MessageType
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration
import kotlin.time.toJavaDuration

@Component
class MessageListener {

    private val log = KotlinLogging.logger {}

    @KafkaListener(topics = [DEFAULT_TOPIC])
    fun message(record: ConsumerRecord<String, MessageResponse>, acknowledgement: Acknowledgment) {
        val message = record.value()

        check(message.type == MessageType.SUCCESS) {
            log.error { "NACK 레코드: $message" }
        }

        log.info { "ACK 레코드: $record" }
        acknowledgement.acknowledge()
    }
}
