/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wandererribbit.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.wandererribbit.item.RibbitMapItem;
import net.mcreator.wandererribbit.WandererRibbitMod;

public class WandererRibbitModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(WandererRibbitMod.MODID);
	public static final DeferredItem<Item> WANDERER_RIBBIT_SPAWN_EGG = REGISTRY.register("wanderer_ribbit_spawn_egg", () -> new DeferredSpawnEggItem(WandererRibbitModEntities.WANDERER_RIBBIT, -11164863, -11569212, new Item.Properties()));
	public static final DeferredItem<Item> RIBBIT_MAP = REGISTRY.register("ribbit_map", RibbitMapItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}