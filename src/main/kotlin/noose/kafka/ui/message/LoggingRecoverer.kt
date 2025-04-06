package noose.kafka.ui.message

import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.listener.ConsumerRecordRecoverer
import java.lang.Exception

class LoggingRecoverer : ConsumerRecordRecoverer {

    private val log = KotlinLogging.logger {}

    override fun accept(record: ConsumerRecord<*, *>, exception: Exception) {
        log.warn { "${record.value()} 재시도 해결" }
    }
}
