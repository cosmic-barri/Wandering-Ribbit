/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wandererribbit.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.wandererribbit.entity.WandererRibbitEntity;
import net.mcreator.wandererribbit.WandererRibbitMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class WandererRibbitModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, WandererRibbitMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<WandererRibbitEntity>> WANDERER_RIBBIT = register("wanderer_ribbit",
			EntityType.Builder.<WandererRibbitEntity>of(WandererRibbitEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		WandererRibbitEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(WANDERER_RIBBIT.get(), WandererRibbitEntity.createAttributes().build());
	}
}