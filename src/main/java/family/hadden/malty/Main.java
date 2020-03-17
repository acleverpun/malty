package family.hadden.malty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod(Main.modId)
@Mod.EventBusSubscriber(modid = Main.modId, bus = Bus.MOD)
public class Main {
	public static final String modId = "malty";
	public static final ItemGroup tab = new Tab(modId);

	public static final Logger log = LogManager.getLogger();

	public Main() {
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
