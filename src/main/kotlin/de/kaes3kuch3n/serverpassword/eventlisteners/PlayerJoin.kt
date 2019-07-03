package de.kaes3kuch3n.serverpassword.eventlisteners

import de.kaes3kuch3n.serverpassword.ServerPassword
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.network.ClientConnectionEvent
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.chat.ChatTypes
import java.time.ZoneId

class PlayerJoin {
    private val logger: Logger = ServerPassword.getPlugin().getLogger()

    @Listener
    fun onJoin(event: ClientConnectionEvent.Join) {
        val player = event.targetEntity
        if (!player.hasPlayedBefore())
            player.sendMessage(ChatTypes.SYSTEM, Text.of("Welcome to Minecraft, ${player.name}!"))
        else
            player.sendMessage(ChatTypes.SYSTEM, Text.of("Welcome back, ${player.name}!"))
    }
}