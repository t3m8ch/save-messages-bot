package io.github.t3m8ch.savemessagesbot.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("Messages")
data class MessageModel(
    @Id val id: ObjectId = ObjectId.get(),
    val createdAt: Instant = Instant.now(),
    val senderId: Long,
    val text: String?,
)
