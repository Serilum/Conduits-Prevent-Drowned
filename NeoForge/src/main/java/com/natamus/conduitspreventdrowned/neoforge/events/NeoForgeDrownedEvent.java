package com.natamus.conduitspreventdrowned.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.conduitspreventdrowned.events.DrownedEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;

@EventBusSubscriber
public class NeoForgeDrownedEvent {
	@SubscribeEvent
	public static void onDrownedSpawn(MobSpawnEvent.PositionCheck e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		if (!DrownedEvent.onDrownedSpawn(e.getEntity(), (ServerLevel)level, null, e.getSpawnType())) {
			e.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
		}
	}
}
