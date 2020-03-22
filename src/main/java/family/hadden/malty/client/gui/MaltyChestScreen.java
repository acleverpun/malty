package family.hadden.malty.client.gui;

import family.hadden.malty.container.MaltyChestContainer;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class MaltyChestScreen extends ContainerScreen<MaltyChestContainer> {
	public MaltyChestScreen(final MaltyChestContainer container, final PlayerInventory inventory, final ITextComponent title) {
		super(container, inventory, title);
	}

	@Override
	public void render(final int mouseX, final int mouseY, final float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		String s = this.title.getFormattedText();
		this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
		AbstractGui.fill(this.guiLeft, this.guiTop + this.ySize, this.guiLeft + this.xSize, this.guiTop, 0xffc7c8c8);
		container.inventorySlots.forEach((slot) -> drawSlot(slot.xPos, slot.yPos));
	}

	protected void drawSlot(int x, int y) {
		x = this.guiLeft + x;
		y = this.guiTop + y;
		AbstractGui.fill(x - 1, y + 17, x + 17, y - 1, 0x99ffffff);
		AbstractGui.fill(x - 1, y + 16, x + 16, y - 1, 0xff333333);
		AbstractGui.fill(x, y + 16, x + 16, y, 0xff8c8c8c);
	}
}
