package family.hadden.malty;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(Main.modId)
public class MaltyItems {
	// public static final MaltyChest maltyChest = null;

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
			new BlockItem(MaltyBlocks.maltyChest, new Item.Properties().group(Main.tab))
				.setRegistryName(MaltyBlocks.maltyChest.getRegistryName())
		);
	}
}
