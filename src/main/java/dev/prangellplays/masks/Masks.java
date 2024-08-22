package dev.prangellplays.masks;

import dev.prangellplays.masks.init.MasksItemGroups;
import dev.prangellplays.masks.init.MasksItems;
import dev.prangellplays.masks.init.MinecraftItemGroupsAddition;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Masks implements ModInitializer {
	public static final String MOD_ID = "masks";
	public static final Logger LOGGER = LoggerFactory.getLogger("masks");

	@Override
	public void onInitialize() {
		MasksItems.init();
		MasksItemGroups.init();
		MinecraftItemGroupsAddition.init();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}