package family.hadden.malty.container;

import java.util.Map;

import javax.annotation.Nullable;

import family.hadden.malty.util.WorldUtils;
import mcjty.lib.container.ContainerFactory;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.tileentity.GenericTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AggregatorContainer extends GenericContainer {
	public int offset = 0;

	public AggregatorContainer(@Nullable ContainerType<?> type, int id, ContainerFactory factory, BlockPos pos, @Nullable GenericTileEntity tile) {
		super(type, id, factory, pos, tile);

		World world = tile.getWorld();
		Map<Direction, TileEntity> tiles = WorldUtils.getAdjacentTiles(world, pos);
		Capability<IItemHandler> cap = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

		tiles.entrySet().stream()
			.filter((it) -> it.getValue().getCapability(cap, it.getKey().getOpposite()) != null)
			.forEach((it) -> {
				int slotIndex = 0;
				for (int row = 0; row < 3; ++row) {
					for (int col = 0; col < 9; ++col) {
						int x = 8 + col * 18;
						int y = 16 + row * 18 + offset;
						LazyOptional<IItemHandler> items = it.getValue().getCapability(cap, it.getKey().getOpposite());
						addSlot(new SlotItemHandler(items.orElse(null), slotIndex++, x, y));
					}
				}
				offset += 64;
			});
		;
	}
}
