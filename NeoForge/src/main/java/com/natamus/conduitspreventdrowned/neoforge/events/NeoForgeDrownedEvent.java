package com.natamus.conduitspreventdrowned.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.conduitspreventdrowned.events.DrownedEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeDrownedEvent {
	@SubscribeEvent
	public static void onDrownedSpawn(MobSpawnEvent.FinalizeSpawn e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}
		
		Entity entity = e.getEntity();
		if (!(entity instanceof Mob)) {
			return;
		}
		
		if (!DrownedEvent.onDrownedSpawn((Mob)entity, (ServerLevel)level, null, e.getSpawnType())) {
			e.setSpawnCancelled(true);
			e.setCanceled(true);
		}
	}
}
