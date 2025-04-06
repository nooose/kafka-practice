package noose.kafka.ui.message

import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.producer.ProducerInterceptor
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import java.lang.Exception

class LoggingProducerInterceptor : ProducerInterceptor<String, Any> {
    private val log = KotlinLogging.logger {}

    override fun onSend(record: ProducerRecord<String, in Any>): ProducerRecord<String, in Any> {
        log.info { "onSend ${record.key()} - ${record.value()}" }
        return record
    }

    override fun onAcknowledgement(meta: RecordMetadata, exception: Exception?) {
        log.info { "onAcknowledgement topic: ${meta.topic()}, partition: ${meta.partition()}, offset: ${meta.offset()}" }
    }

    override fun close() {
        // TODO: close
    }

    override fun configure(p0: Map<String, *>) {
        // TODO: configure
    }
}
