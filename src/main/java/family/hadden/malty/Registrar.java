package family.hadden.malty;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Main.modId, bus = Bus.MOD)
public class Registrar {
	public void register() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		MaltyBlocks.register(event.getRegistry());
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		MaltyItems.register(event.getRegistry());
	}
}
