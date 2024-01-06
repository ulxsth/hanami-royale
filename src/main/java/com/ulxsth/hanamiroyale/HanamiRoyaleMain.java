package com.ulxsth.hanamiroyale;

import org.bukkit.plugin.java.JavaPlugin;

public final class HanamiRoyaleMain extends JavaPlugin {
    private static HanamiRoyaleMain instance = null;

    public static HanamiRoyaleMain getInstance() {
        if(instance == null) {
            throw new IllegalArgumentException("Plugin is null");
        }
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        try {
            this.getCommand("start").setExecutor(new com.ulxsth.hanamiroyale.commands.StartTimerExecuter());
            this.getCommand("cgive").setExecutor(new com.ulxsth.hanamiroyale.commands.CustomGiveExecuter());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
