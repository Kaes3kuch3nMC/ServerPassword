package de.kaes3kuch3n.serverpassword.commands

import de.kaes3kuch3n.serverpassword.PluginInfo.Companion.ID
import de.kaes3kuch3n.serverpassword.ServerPassword
import org.spongepowered.api.Sponge
import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.format.TextColors

class Password : CommandExecutor {
    init {
        val spec = CommandSpec.builder()
                .description(Text.of("Unlock your account using the server's password"))
                .permission("$ID.command.password")
                .executor(this)
                .build()
        Sponge.getCommandManager().register(ServerPassword.getPlugin(), spec, "password", "pw")
    }

    override fun execute(src: CommandSource, args: CommandContext): CommandResult {
        if (src !is Player) {
            src.sendMessage(Text.of(TextColors.RED, "Only players may use the password command!"))
            return CommandResult.empty()
        }
        src.sendMessage(Text.of(TextColors.GREEN, "Congratulations! You have unlocked your account successfully!"))
        return CommandResult.success()
    }
}