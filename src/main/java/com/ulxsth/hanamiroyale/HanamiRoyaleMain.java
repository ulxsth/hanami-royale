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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
