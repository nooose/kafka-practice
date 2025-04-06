package noose.kafka.ui.message

import jakarta.validation.constraints.NotBlank
import noose.kafka.ui.shared.MessageType

data class MessageResponse(
    val type: MessageType,
    @field:NotBlank
    val data: String,
) {
}
