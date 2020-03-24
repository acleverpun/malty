package family.hadden.malty.container;
import java.util.Objects;

import javax.annotation.Nonnull;

import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.Containers;
import family.hadden.malty.tileEntity.AggregatorTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class AggregatorContainer extends Container {
	public final AggregatorTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public AggregatorContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public AggregatorContainer(final int windowId, final PlayerInventory playerInventory, final AggregatorTileEntity tileEntity) {
		super(Containers.aggregator.get(), windowId);
		this.tileEntity = tileEntity;
		canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
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
