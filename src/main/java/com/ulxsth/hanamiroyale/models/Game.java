package com.ulxsth.hanamiroyale.models;

import com.ulxsth.hanamiroyale.HanamiRoyaleMain;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Game {
    private static final int TIME = 20;

    private HanamiRoyaleMain plugin = HanamiRoyaleMain.getInstance();
    private int time;

    public void startTimer() {
        this.time = TIME;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            plugin.getLogger().info("Time left: " + time);
            if(time > 0) {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 5));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, 5));
                });
                time--;
            } else {
                plugin.getLogger().info("Time's up!");
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.getActivePotionEffects().forEach(potionEffect -> {
                        player.removePotionEffect(potionEffect.getType());
                    });
                });
                Bukkit.getScheduler().cancelTasks(plugin);
            }
        }, 0L, 20L);
    }
}
