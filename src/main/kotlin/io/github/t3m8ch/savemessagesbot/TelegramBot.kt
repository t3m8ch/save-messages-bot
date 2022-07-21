package io.github.t3m8ch.savemessagesbot

import io.github.t3m8ch.savemessagesbot.models.MessageModel
import io.github.t3m8ch.savemessagesbot.repositories.MessageRepository
import org.springframework.stereotype.Component
import org.telegram.abilitybots.api.bot.AbilityBot
import org.telegram.abilitybots.api.objects.Ability
import org.telegram.abilitybots.api.objects.Locality
import org.telegram.abilitybots.api.objects.Privacy
import org.telegram.abilitybots.api.objects.Reply
import org.telegram.abilitybots.api.util.AbilityUtils.getUser

@Component
class TelegramBot(
    private val props: TelegramBotProps,
    private val repo: MessageRepository,
) : AbilityBot(props.botToken, props.botUsername) {
    override fun creatorId() = props.botCreatorId

    fun saveMessage() = Reply.of(
        { _, update ->
            val messageModel = MessageModel(senderId = getUser(update).id, text = update.message.text)
            repo.save(messageModel)
        },
        { update ->
            update.hasMessage()
                    && (update.message.isGroupMessage || update.message.isSuperGroupMessage)
                    && update.message?.text != "/statistics"
        }
    )

    fun statsCommand() = Ability.builder()
        .name("statistics")
        .privacy(Privacy.PUBLIC)
        .locality(Locality.ALL)
        .action { ctx ->
            val countOfMessages = repo.count()
            silent.send("Кол-во сообщений: $countOfMessages", ctx.chatId())
        }
        .build()
}
