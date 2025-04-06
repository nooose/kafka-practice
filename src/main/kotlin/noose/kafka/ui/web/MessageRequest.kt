package noose.kafka.ui.web

import jakarta.validation.constraints.NotBlank

data class MessageRequest(
    @field:NotBlank
    val data: String,
)
