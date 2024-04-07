package com.gardensmc.friendlyhostiles.listener;

import com.gardensmc.friendlyhostiles.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.Set;

public class MobListener implements Listener {

    private static final Set<EntityTargetEvent.TargetReason> unprovokedReasons = Set.of(
            EntityTargetEvent.TargetReason.RANDOM_TARGET,
            EntityTargetEvent.TargetReason.CLOSEST_ENTITY,
            EntityTargetEvent.TargetReason.CLOSEST_PLAYER,
            EntityTargetEvent.TargetReason.COLLISION
    );

    @EventHandler
    public void onMobTarget(EntityTargetLivingEntityEvent event) {
        if (event.getTarget() instanceof Player player) {
            if (player.hasPermission(Permissions.preventAttackAll)) {
                event.setCancelled(true);
            } else if (unprovokedReasons.contains(event.getReason()) && player.hasPermission(Permissions.preventAttackUnprovoked)) {
                event.setCancelled(true);
            }
        }
    }
}
