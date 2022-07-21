package io.github.t3m8ch.savemessagesbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SaveMessagesBotApplication

fun main(args: Array<String>) {
    runApplication<SaveMessagesBotApplication>(*args)
}
