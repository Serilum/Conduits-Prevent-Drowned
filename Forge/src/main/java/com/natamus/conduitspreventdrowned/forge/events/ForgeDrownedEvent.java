package com.natamus.conduitspreventdrowned.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.conduitspreventdrowned.events.DrownedEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeDrownedEvent {
	@SubscribeEvent
	public void onDrownedSpawn(LivingSpawnEvent.CheckSpawn e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}
		
		Entity entity = e.getEntity();
		if (!(entity instanceof Mob)) {
			return;
		}
		
		if (!DrownedEvent.onDrownedSpawn((Mob)entity, (ServerLevel)level, null, e.getSpawnReason())) {
			e.setResult(Event.Result.DENY);
		}
	}
}
