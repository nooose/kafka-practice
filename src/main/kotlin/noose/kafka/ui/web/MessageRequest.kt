package noose.kafka.ui.web

import jakarta.validation.constraints.NotBlank
import noose.kafka.ui.shared.MessageType

data class MessageRequest(
    val type: MessageType,
    @field:NotBlank
    val data: String,
)
