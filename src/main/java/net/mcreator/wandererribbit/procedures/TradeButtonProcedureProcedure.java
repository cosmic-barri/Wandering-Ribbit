package net.mcreator.wandererribbit.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.wandererribbit.init.WandererRibbitModMenus;
import net.mcreator.wandererribbit.init.WandererRibbitModItems;
import net.mcreator.wandererribbit.entity.WandererRibbitEntity;

import java.util.Comparator;

public class TradeButtonProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD
					&& getAmountInGUISlot(entity, 0) >= 7
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.COMPASS
					&& getAmountInGUISlot(entity, 0) >= 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.frog.ambient")), SoundSource.NEUTRAL, 3, 3);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.frog.ambient")), SoundSource.NEUTRAL, 3, 3, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(7);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(WandererRibbitModItems.RIBBIT_MAP.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(2).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				(findEntityInWorldRange(world, WandererRibbitEntity.class, x, y, z, 4)).push(0, 0.2, 0);
				if ((findEntityInWorldRange(world, WandererRibbitEntity.class, x, y, z, 4)) instanceof WandererRibbitEntity) {
					((WandererRibbitEntity) (findEntityInWorldRange(world, WandererRibbitEntity.class, x, y, z, 4))).setAnimation("dance");
				}
			}
			if (ModList.get().isLoaded("barris_botany")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD
						&& getAmountInGUISlot(entity, 0) >= 22
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD
						&& getAmountInGUISlot(entity, 0) >= 3) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.frog.ambient")), SoundSource.NEUTRAL, 3, 3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.frog.ambient")), SoundSource.NEUTRAL, 3, 3, false);
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(22);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(3);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("barris_botany:frog_pill"))).copy();
						_setstack.setCount(1);
						_menu.getSlots().get(2).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof WandererRibbitModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}