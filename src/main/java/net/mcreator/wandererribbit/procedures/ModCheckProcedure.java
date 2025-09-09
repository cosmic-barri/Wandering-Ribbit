package net.mcreator.wandererribbit.procedures;

import net.neoforged.fml.ModList;

public class ModCheckProcedure {
	public static boolean execute() {
		return ModList.get().isLoaded("barris_botany");
	}
}