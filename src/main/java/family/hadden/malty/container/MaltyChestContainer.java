package family.hadden.malty.container;

import java.util.Objects;

import javax.annotation.Nonnull;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.Containers;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.items.SlotItemHandler;

public class MaltyChestContainer extends Container {
	public final MaltyChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public MaltyChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public MaltyChestContainer(final int windowId, final PlayerInventory playerInventory, final MaltyChestTileEntity tileEntity) {
		super(Containers.maltyChest.get(), windowId);
		this.tileEntity = tileEntity;
		canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		addOwnSlots();
		addPlayerSlots(playerInventory);
	}

	private void addOwnSlots() {
		int slotIndex = 0;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 8 + col * 18;
				int y = 16 + row * 18;
				addSlot(new SlotItemHandler(tileEntity.inventory, slotIndex++, x, y));
			}
		}
	}

	private void addPlayerSlots(IInventory playerInventory) {
		// Slots for the main inventory
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 8 + col * 18;
				int y = 84 + row * 18;
				addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}

		// Slots for the hotbar
		for (int row = 0; row < 9; ++row) {
			int x = 8 + row * 18;
			int y = 72 + 70;
			addSlot(new Slot(playerInventory, row, x, y));
		}
	}

	private static MaltyChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
		Objects.requireNonNull(data, "data cannot be null!");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof MaltyChestTileEntity)
			return (MaltyChestTileEntity) tileAtPos;
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	@Nonnull
	@Override
	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
		ItemStack returnStack = ItemStack.EMPTY;
		final Slot slot = inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			final ItemStack slotStack = slot.getStack();
			returnStack = slotStack.copy();

			final int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
			if (index < containerSlots) {
				if (!mergeItemStack(slotStack, containerSlots, inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
			if (slotStack.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			if (slotStack.getCount() == returnStack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(player, slotStack);
		}
		return returnStack;
	}

	@Override
	public boolean canInteractWith(@Nonnull final PlayerEntity player) {
		return isWithinUsableDistance(canInteractWithCallable, player, Blocks.maltyChest.get());
	}
}
