package family.hadden.malty.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;

import family.hadden.malty.Main;
import family.hadden.malty.container.MaltyChestContainer;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class MaltyChestScreen extends ContainerScreen<MaltyChestContainer> {
	private static final ResourceLocation backgroundTexture = new ResourceLocation(Main.modId, "textures/gui/container/malty-chest.png");

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
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		getMinecraft().getTextureManager().bindTexture(backgroundTexture);
		int startX = this.guiLeft;
		int startY = this.guiTop;

		this.blit(startX, startY, 0, 0, this.xSize, this.ySize);

		final MaltyChestTileEntity tileEntity = container.tileEntity;

		if (!tileEntity.inventory.getStackInSlot(MaltyChestTileEntity.FUEL_SLOT).isEmpty()) {
			this.blit(
				startX + 81, startY + 58,
				176, 0,
				14, 14
			);
		}
	}
}
