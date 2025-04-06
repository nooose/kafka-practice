package noose.kafka.ui.web

import jakarta.validation.Valid
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageProducerRestController(
    private val kafkaTemplate: KafkaTemplate<String, MessageRequest>
) {

    @PostMapping("/messages")
    fun produce(@RequestBody @Valid request: MessageRequest) {
        kafkaTemplate.send("test-topic", request)
    }
}
