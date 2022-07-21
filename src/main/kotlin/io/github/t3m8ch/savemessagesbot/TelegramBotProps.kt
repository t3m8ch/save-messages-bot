package io.github.t3m8ch.savemessagesbot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class TelegramBotProps(
    @Value("\${telegram.bot-token}") val botToken: String,
    @Value("\${telegram.bot-username}") val botUsername: String,
    @Value("\${telegram.bot-creator-id}") val botCreatorId: Long,
)