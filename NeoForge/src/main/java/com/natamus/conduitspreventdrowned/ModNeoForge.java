package com.natamus.conduitspreventdrowned;

import com.natamus.collective.check.RegisterMod;
import com.natamus.conduitspreventdrowned.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.conduitspreventdrowned.neoforge.events.NeoForgeDrownedEvent;
import com.natamus.conduitspreventdrowned.util.Reference;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeDrownedEvent.class);
	}

	private static void setGlobalConstants() {

	}
}