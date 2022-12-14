package me.xhyrom.hyx.commands.gamemodes;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import dev.jorel.commandapi.annotations.arguments.APlayerArgument;
import me.xhyrom.hyx.HyX;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@Command("gma")
@Permission("hyx.command.gamemode.adventure")
public class Gma {
    @Default
    public static void gma(Player player) {
        player.setGameMode(GameMode.ADVENTURE);

        player.sendMessage(MiniMessage.miniMessage().deserialize(
                HyX.Companion.getInstance().lang().getString("commands.gamemode.success.message").get(),
                Placeholder.component(
                        "type",
                        Component.text(
                                HyX.Companion.getInstance().lang().getString("commands.gamemode.types.adventure").get()
                        )
                )
        ));
    }

    @Default
    @Permission("hyx.command.gamemode.adventure.others")
    public static void gma(Player player, @APlayerArgument Player target) {
        target.setGameMode(GameMode.ADVENTURE);

        player.sendMessage(MiniMessage.miniMessage().deserialize(
                HyX.Companion.getInstance().lang().getString("commands.gamemode.success.other-message").get(),
                Placeholder.component(
                        "type",
                        Component.text(
                                HyX.Companion.getInstance().lang().getString("commands.gamemode.types.adventure").get()
                        )
                ),
                Placeholder.component("player", target.name()),
                Placeholder.component("player_displayname", target.displayName())
        ));
    }
}
