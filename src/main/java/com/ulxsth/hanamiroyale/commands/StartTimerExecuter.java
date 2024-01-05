package com.ulxsth.hanamiroyale.commands;

import com.ulxsth.hanamiroyale.models.Game;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StartTimerExecuter implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Game game = new Game();
        game.startTimer();
        return true;
    }
}
