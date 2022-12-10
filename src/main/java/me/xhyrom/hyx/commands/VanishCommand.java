package me.xhyrom.hyx.commands;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import me.xhyrom.hyx.HyX;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

@Command("vanish")
@Permission("hyx.command.vanish")
public class VanishCommand {
    @Default
    public static void onDefault(
            Player player
    ) {
        HyX.Companion.getInstanceUnsafe().modules().getVanish().setVanished(
                player,
                !HyX.Companion.getInstanceUnsafe().modules().getVanish().isVanished(player)
        );

        player.sendMessage(MiniMessage.miniMessage().deserialize(
                HyX.Companion.getInstanceUnsafe().lang().getString(
                        "commands.vanish." +
                                (HyX.Companion.getInstanceUnsafe().modules().getVanish().isVanished(player)
                                        ? "enable.message"
                                        : "disable.message"
                                )
                ).get()
        ));
    }
}
