/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wandererribbit.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.wandererribbit.client.renderer.WandererRibbitRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WandererRibbitModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(WandererRibbitModEntities.WANDERER_RIBBIT.get(), WandererRibbitRenderer::new);
	}
}