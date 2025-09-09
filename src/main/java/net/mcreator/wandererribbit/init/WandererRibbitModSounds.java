/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wandererribbit.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.wandererribbit.WandererRibbitMod;

public class WandererRibbitModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, WandererRibbitMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> WANDERER_RIBBIT_AMBIENT = REGISTRY.register("wanderer_ribbit_ambient",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("wanderer_ribbit", "wanderer_ribbit_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WANDERER_RIBBIT_HURT = REGISTRY.register("wanderer_ribbit_hurt",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("wanderer_ribbit", "wanderer_ribbit_hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WANDERER_RIBBIT_DEATH = REGISTRY.register("wanderer_ribbit_death",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("wanderer_ribbit", "wanderer_ribbit_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WANDERER_RIBBIT_STEP = REGISTRY.register("wanderer_ribbit_step",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("wanderer_ribbit", "wanderer_ribbit_step")));
}