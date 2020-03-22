package family.hadden.malty.util;

import java.util.Map;
import java.util.TreeMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public final class WorldUtils {
	public static Map<Direction, TileEntity> getAdjacentTiles(IBlockReader world, BlockPos pos) {
		Map<Direction, TileEntity> tiles = new TreeMap<>();

		for (Direction dir : Direction.values()) {
			BlockPos blockPos = pos.add(dir.getXOffset(), dir.getYOffset(), dir.getZOffset());
			TileEntity tileEntity = world.getTileEntity(blockPos);

			if (tileEntity != null) {
				tiles.put(dir, tileEntity);
			}
		}

		return tiles;
	}
}
