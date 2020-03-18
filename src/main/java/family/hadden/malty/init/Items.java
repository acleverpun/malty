package family.hadden.malty.init;

import family.hadden.malty.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Items {
	public static final DeferredRegister<Item> registry = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.modId);

	public static final RegistryObject<Item> maltyChest = registry.register(
		"malty-chest",
		() -> new BlockItem(Blocks.maltyChest.get(), new Item.Properties().group(Main.tab))
	);
}
