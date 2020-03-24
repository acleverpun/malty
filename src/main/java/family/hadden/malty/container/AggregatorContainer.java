package family.hadden.malty.container;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.Containers;
import family.hadden.malty.tileEntity.AggregatorTileEntity;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import family.hadden.malty.util.WorldUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AggregatorContainer extends Container {
	public final AggregatorTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	public int offset = 0;

	public AggregatorContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public AggregatorContainer(final int windowId, final PlayerInventory playerInventory, final AggregatorTileEntity tileEntity) {
		super(Containers.aggregator.get(), windowId);
		this.tileEntity = tileEntity;
		World world = tileEntity.getWorld();
		BlockPos pos = tileEntity.getPos();
		canInteractWithCallable = IWorldPosCallable.of(world, pos);

		Map<Direction, TileEntity> tiles = WorldUtils.getAdjacentTiles(world, pos);
		Capability<IItemHandler> cap = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

		tiles.entrySet().stream()
			.filter((it) -> it.getValue().getCapability(cap, it.getKey().getOpposite()) != null)
			.filter((it) -> it.getValue() instanceof MaltyChestTileEntity)
			.forEach((it) -> {
				addSlots((MaltyChestTileEntity) it.getValue());
			})
		;

		addPlayerSlots(playerInventory);
	}

	private void addSlots(MaltyChestTileEntity tile) {
		int slotIndex = 0;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 8 + col * 18;
				int y = 16 + row * 18 + offset;
				addSlot(new SlotItemHandler(tile.inventory, slotIndex++, x, y));
			}
		}
		offset += 64;
	}

	private void addPlayerSlots(IInventory playerInventory) {
		// Slots for the main inventory
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				int x = 8 + col * 18;
				int y = 84 + row * 18 + 64;
				addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}

		// Slots for the hotbar
		for (int row = 0; row < 9; ++row) {
			int x = 8 + row * 18;
			int y = 72 + 70 + 64;
			addSlot(new Slot(playerInventory, row, x, y));
		}
	}

	private static AggregatorTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
		Objects.requireNonNull(data, "data cannot be null!");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof AggregatorTileEntity) return (AggregatorTileEntity) tileAtPos;
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	@Override
	public boolean canInteractWith(@Nonnull final PlayerEntity player) {
		return isWithinUsableDistance(canInteractWithCallable, player, Blocks.aggregator.get());
	}
}
