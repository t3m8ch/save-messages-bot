package io.github.t3m8ch.savemessagesbot.repositories

import io.github.t3m8ch.savemessagesbot.models.MessageModel
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<MessageModel, ObjectId>
