package net.mcreator.wandererribbit.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;


public class RibbitMapRightclickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && _player.level() instanceof ServerLevel _level) {
            // Estructura objetivo
            ResourceKey<Structure> structureKey = ResourceKey.create(
                net.minecraft.core.registries.Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath("ribbits", "ribbit_village")
            );

            // Obtener el HolderSet de la estructura
            var structureRegistry = _level.registryAccess().registryOrThrow(net.minecraft.core.registries.Registries.STRUCTURE);
            var holder = structureRegistry.getHolderOrThrow(structureKey);
            HolderSet<Structure> holderSet = HolderSet.direct(holder);

            // Buscar la estructura más cercana
            BlockPos playerPos = _player.blockPosition();
            BlockPos targetPos = null;
            var result = _level.getChunkSource().getGenerator().findNearestMapStructure(
                _level, holderSet, playerPos, 100, false
            );

            if (result != null) {
                targetPos = result.getFirst(); // devuelve BlockPos
            }

            if (targetPos != null) {
			    // Crear el mapa
			    ItemStack map = MapItem.create(_level, targetPos.getX(), targetPos.getZ(), (byte) 2, true, true);
			
			    // Poner nombre personalizado
			    map.set(DataComponents.CUSTOM_NAME, Component.literal("Ribbit Village Map"));
			
			    // Añadir el marcador
			    MapItemSavedData.addTargetDecoration(map, targetPos, "+", MapDecorationTypes.TARGET_X);
			
			    // Dar el mapa al jugador
			    ItemHandlerHelper.giveItemToPlayer(_player, map);
			
			    // Eliminar el ítem inicial (consumir 1)
			    _player.getMainHandItem().shrink(1);
			}
        }
    }
}

