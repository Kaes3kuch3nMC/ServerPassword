package de.kaes3kuch3n.serverpassword

import com.google.inject.Inject
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.AUTHOR
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.DESCRIPTION
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.ID
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.NAME
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.URL
import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.VERSION
import de.kaes3kuch3n.serverpassword.commands.Password
import de.kaes3kuch3n.serverpassword.eventlisteners.PlayerJoin
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameInitializationEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.plugin.PluginContainer

@Plugin(id = ID, name = NAME, description = DESCRIPTION, version = VERSION, authors = [AUTHOR], url = URL)
class ServerPassword {
    companion object {
        private var instance: ServerPassword? = null

        fun getPlugin(): ServerPassword {
            return instance!!
        }
    }

    @Inject
    private lateinit var logger: Logger

    init {
        instance = this
    }

    @Listener
    fun onInit(event: GameInitializationEvent) {
        logger.info("Registering event listeners...")
        Sponge.getEventManager().registerListeners(this, PlayerJoin())

        logger.info("Setting up commands...")
        Password()
    }

    fun getLogger(): Logger {
        return logger
    }
}