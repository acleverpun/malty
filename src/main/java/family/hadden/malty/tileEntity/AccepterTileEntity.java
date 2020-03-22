package family.hadden.malty.tileEntity;

import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

public class AccepterTileEntity extends TileEntity {
	public AccepterTileEntity() {
		super(TileEntityTypes.accepter.get());
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			IBlockReader world = getWorld();

			for (Direction dir : Direction.values()) {
				BlockPos blockPos = pos.add(dir.getXOffset(), dir.getYOffset(), dir.getZOffset());
				TileEntity tileEntity = world.getTileEntity(blockPos);
				if (tileEntity instanceof MaltyChestTileEntity) {
					return tileEntity.getCapability(cap);
				}
			}
		}
		return super.getCapability(cap, side);
	}
}
