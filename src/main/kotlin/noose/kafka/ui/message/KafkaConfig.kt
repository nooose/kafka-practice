package noose.kafka.ui.message

import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.util.backoff.FixedBackOff
import java.util.function.BiConsumer

@EnableKafka
@Configuration(proxyBeanMethods = false)
class KafkaConfig {

    private val log = KotlinLogging.logger {}

    @Bean
    fun errorHandler(): DefaultErrorHandler {
        val backOff = FixedBackOff(1000L, 2L)
        return DefaultErrorHandler(LoggingRecoverer(), backOff)
    }

}

