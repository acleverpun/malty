package family.hadden.malty.init;

import family.hadden.malty.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Main.modId, bus = Bus.MOD)
@ObjectHolder(Main.modId)
public class ItemInit {
	public static Item sturk;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		sturk = new Item(new Item.Properties().group(ItemGroup.MISC))
			.setRegistryName("sturk");

		event.getRegistry().registerAll(
			sturk
		);
	}
}
