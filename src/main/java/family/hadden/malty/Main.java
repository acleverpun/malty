package family.hadden.malty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.Containers;
import family.hadden.malty.init.Items;
import family.hadden.malty.init.TileEntityTypes;
import mcjty.lib.base.ModBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.modId)
public class Main implements ModBase {
	public static final String modId = "malty";

	public static Main instance;

	public static final Logger log = LogManager.getLogger();

	public Main() {
		instance = this;
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		Blocks.registry.register(eventBus);
		Items.registry.register(eventBus);
		Containers.registry.register(eventBus);
		TileEntityTypes.registry.register(eventBus);
	}

	@Override
	public String getModId() {
		return modId;
	}

	@Override
	public void openManual(PlayerEntity player, int bookIndex, String page) {
		log.debug("openManual");
	}
}
