package family.hadden.malty.client.gui;

import family.hadden.malty.Main;
import family.hadden.malty.init.Messages;
import family.hadden.malty.tileEntity.AggregatorTileEntity;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.Window;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;

public class AggregatorScreen extends GenericGuiContainer<AggregatorTileEntity, GenericContainer> {
	public AggregatorScreen(AggregatorTileEntity tileEntity, GenericContainer container, PlayerInventory inventory) {
		super(Main.instance, tileEntity, container, inventory, 0, "aggregator");
	}

	@Override
	public void init() {
		Main.log.debug("aoeu.init");
		window = new Window(this, tileEntity, Messages.instance, new ResourceLocation(Main.modId, "gui/aggregator.gui"));
		super.init();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
		Main.log.debug("aoeu.drawGuiContainerBackgroundLayer");
		drawWindow();
	}
}
