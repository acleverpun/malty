package family.hadden.malty.tileEntity;

import java.util.Map;

import family.hadden.malty.Main;
import family.hadden.malty.init.TileEntityTypes;
import family.hadden.malty.util.WorldUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
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
		// Proxy items into adjacent inventories
		// Order will be the order of the Direction enum values
		// TODO: make order configurable, or at least a sane default
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			IBlockReader world = getWorld();
			Map<Direction, TileEntity> tiles = WorldUtils.getAdjacentTiles(world, pos);

			// Remove item source
			tiles.remove(side);

			// Remove other instances of this same class
			Map.Entry<Direction, TileEntity> entry = tiles.entrySet().stream()
				.filter((ent) -> ent.getValue().getClass() != this.getClass())
				.findFirst()
				.orElse(null)
			;

			if (entry != null) {
				return entry.getValue().getCapability(cap, entry.getKey().getOpposite());
			}
		}
		return super.getCapability(cap, side);
	}
}
