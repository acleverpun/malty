package family.hadden.malty.tileEntity;

import javax.annotation.Nonnull;

import family.hadden.malty.container.MaltyChestContainer;
import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class MaltyChestTileEntity extends TileEntity implements INamedContainerProvider {
	public final ItemStackHandler inventory = new ItemStackHandler(9 * 3) {
		@Override
		protected void onContentsChanged(final int slot) {
			super.onContentsChanged(slot);
			MaltyChestTileEntity.this.markDirty();
		}
	};

	private final LazyOptional<ItemStackHandler> inventoryCap = LazyOptional.of(() -> this.inventory);

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

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return inventoryCap.cast();
		return super.getCapability(cap, side);
	}
}
