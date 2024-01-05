package com.ulxsth.hanamiroyale.models;

import com.ulxsth.hanamiroyale.HanamiRoyaleMain;
import org.bukkit.Bukkit;

public class Game {
    private static final int TIME = 20;

    private HanamiRoyaleMain plugin;
    private int time;

    public void startTimer() {
        this.time = TIME;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if(time > 0) {
                    plugin.getLogger().info("Time left: " + time);
                    time--;
                } else {
                    plugin.getLogger().info("Time's up!");
                    Bukkit.getScheduler().cancelTasks(plugin);
                }
            }
        }, 0L, 20L);
    }
}
