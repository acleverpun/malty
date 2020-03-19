package family.hadden.malty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.Items;
import family.hadden.malty.init.TileEntityTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.modId)
public class Main {
	public static final String modId = "malty";

	public static final Logger log = LogManager.getLogger();

	public Main() {
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		Blocks.registry.register(eventBus);
		Items.registry.register(eventBus);
		TileEntityTypes.registry.register(eventBus);
	}
}
