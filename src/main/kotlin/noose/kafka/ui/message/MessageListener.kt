package noose.kafka.ui.message

import io.github.oshai.kotlinlogging.KotlinLogging
import noose.kafka.ui.shared.DEFAULT_TOPIC
import noose.kafka.ui.shared.MessageType
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.stereotype.Component

@Component
class MessageListener {

    private val log = KotlinLogging.logger {}

    @KafkaListener(
        topics = [DEFAULT_TOPIC],
        properties = [
            JsonDeserializer.USE_TYPE_INFO_HEADERS + ":false",
            JsonDeserializer.VALUE_DEFAULT_TYPE + ":noose.kafka.ui.message.MessageResponse"
        ]
    )
    fun message(record: ConsumerRecord<String, MessageResponse>, acknowledgement: Acknowledgment) {
        val message = record.value()

        check(message.type == MessageType.SUCCESS) {
            log.error { "NACK 레코드: $message" }
        }

        log.info { "ACK 레코드: $record" }
        acknowledgement.acknowledge()
    }
}
