package net.mcreator.wandererribbit.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.wandererribbit.entity.WandererRibbitEntity;

public class WandererRibbitModel extends GeoModel<WandererRibbitEntity> {
	@Override
	public ResourceLocation getAnimationResource(WandererRibbitEntity entity) {
		return ResourceLocation.parse("wanderer_ribbit:animations/merchant_ribbit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WandererRibbitEntity entity) {
		return ResourceLocation.parse("wanderer_ribbit:geo/merchant_ribbit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WandererRibbitEntity entity) {
		return ResourceLocation.parse("wanderer_ribbit:textures/entities/" + entity.getTexture() + ".png");
	}

}