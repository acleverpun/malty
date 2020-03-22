package family.hadden.malty.init;

import family.hadden.malty.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Main.modId, bus = EventBusSubscriber.Bus.MOD)
public final class Items {
	public static final DeferredRegister<Item> registry = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.modId);

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		// Automatically register BlockItems for all Blocks
		Blocks.registry.getEntries().stream()
			.map(RegistryObject::get)
			.forEach((block) -> {
				Main.log.debug("onRegisterItems " + block.getRegistryName());
				final Item.Properties properties = new Item.Properties().group(Tabs.malty);
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			});
	}
}
