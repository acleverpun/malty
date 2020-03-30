package family.hadden.malty.client.gui;

import family.hadden.malty.Main;
import family.hadden.malty.init.Messages;
import family.hadden.malty.tileEntity.AggregatorTileEntity;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.Window;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;

public class AggregatorScreen extends GenericGuiContainer<AggregatorTileEntity, GenericContainer> {
	public AggregatorScreen(AggregatorTileEntity tileEntity, GenericContainer container, PlayerInventory inventory) {
		super(Main.instance, tileEntity, container, inventory, 0, "aggregator");
	}

	@Override
	public void init() {
		window = new Window(this, tileEntity, Messages.instance, new ResourceLocation(Main.modId, "gui/aggregator.gui"));
		super.init();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
		drawWindow();
		container.inventorySlots.forEach(this::drawSlotBackground);
	}

	protected void drawSlotBackground(Slot slot) {
		int x = guiLeft + slot.xPos;
		int y = guiTop + slot.yPos;
		AbstractGui.fill(x - 1, y + 17, x + 17, y - 1, 0x99ffffff);
		AbstractGui.fill(x - 1, y + 16, x + 16, y - 1, 0xff333333);
		AbstractGui.fill(x, y + 16, x + 16, y, 0xff8c8c8c);
	}
}
