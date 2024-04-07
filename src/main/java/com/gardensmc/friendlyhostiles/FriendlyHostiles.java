package com.gardensmc.friendlyhostiles;

import com.gardensmc.friendlyhostiles.listener.MobListener;
import org.bukkit.plugin.java.JavaPlugin;

public class FriendlyHostiles extends JavaPlugin {

    @Override
    public void onEnable() {
        // register listeners
        getServer().getPluginManager().registerEvents(new MobListener(), this);
    }
}
