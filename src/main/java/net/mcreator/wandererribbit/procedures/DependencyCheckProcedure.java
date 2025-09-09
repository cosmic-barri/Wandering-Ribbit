package net.mcreator.wandererribbit.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DependencyCheckProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!ModList.get().isLoaded("ribbits")) {
			for (int index0 = 0; index0 < 7; index0++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DESCARGA RIBBITS O NADA FUNCIONARA"), false);
			}
			for (int index1 = 0; index1 < 7; index1++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DOWNLOAD RIBBITS OR NOTHING WILL WORK"), false);
			}
		}
		if (!ModList.get().isLoaded("geckolib")) {
			for (int index2 = 0; index2 < 7; index2++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DESCARGA GECKOLIB O NADA FUNCIONARA"), false);
			}
			for (int index3 = 0; index3 < 7; index3++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DOWNLOAD GECKOLIB OR NOTHING WILL WORK"), false);
			}
		}
		if (!ModList.get().isLoaded("yungsapi")) {
			for (int index4 = 0; index4 < 7; index4++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DESCARGA YUNGSAPI O NADA FUNCIONARA"), false);
			}
			for (int index5 = 0; index5 < 7; index5++) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("DOWNLOAD YUNGSAPI OR NOTHING WILL WORK"), false);
			}
		}
	}
}