package family.hadden.malty.tileEntity;

import javax.annotation.Nonnull;

import family.hadden.malty.container.MaltyChestContainer;
import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;

public class MaltyChestTileEntity extends TileEntity implements INamedContainerProvider {
	public static final int FUEL_SLOT = 0;

	public final ItemStackHandler inventory = new ItemStackHandler(1) {
		@Override
		public boolean isItemValid(final int slot, @Nonnull final ItemStack stack) {
			return true;
		}

		@Override
		protected void onContentsChanged(final int slot) {
			super.onContentsChanged(slot);
			MaltyChestTileEntity.this.markDirty();
		}
	};

	public MaltyChestTileEntity() {
		super(TileEntityTypes.maltyChest.get());
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent(Blocks.maltyChest.get().getTranslationKey());
	}

	@Nonnull
	@Override
	public Container createMenu(final int windowId, final PlayerInventory inventory, final PlayerEntity player) {
		return new MaltyChestContainer(windowId, inventory, this);
	}
}
