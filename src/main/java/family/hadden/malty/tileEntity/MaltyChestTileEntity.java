package family.hadden.malty.tileEntity;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class MaltyChestTileEntity extends TileEntity /* implements INamedContainerProvider */ {
	public MaltyChestTileEntity() {
		super(TileEntityTypes.maltyChest.get());
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent(Blocks.maltyChest.get().getTranslationKey());
	}

	// public Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player) {
	// 	return new MaltyChestContainer(windowId, inventory, this);
	// }
}
