package family.hadden.malty.client;

import family.hadden.malty.Main;
import family.hadden.malty.client.gui.AggregatorScreen;
import family.hadden.malty.client.gui.MaltyChestScreen;
import family.hadden.malty.init.Containers;
import mcjty.lib.gui.GenericGuiContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Cadiboo
 */
@EventBusSubscriber(modid = Main.modId, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {
	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		GenericGuiContainer.register(Containers.aggregator.get(), AggregatorScreen::new);
		ScreenManager.registerFactory(Containers.maltyChest.get(), MaltyChestScreen::new);
	}
}
