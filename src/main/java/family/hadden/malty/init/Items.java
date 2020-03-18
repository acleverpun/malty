package family.hadden.malty.init;

import family.hadden.malty.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.modId)
public class Items {
	// public static final MaltyChest maltyChest = null;

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
			new BlockItem(Blocks.maltyChest, new Item.Properties().group(Main.tab))
				.setRegistryName(Blocks.maltyChest.getRegistryName())
		);
	}
}
