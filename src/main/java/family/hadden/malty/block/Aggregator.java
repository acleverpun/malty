package family.hadden.malty.block;

import java.util.Map;

import javax.annotation.Nullable;

import family.hadden.malty.init.TileEntityTypes;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import family.hadden.malty.util.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class Aggregator extends Block {
	public Aggregator() {
		super(Block.Properties.create(Material.WOOD));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
		return TileEntityTypes.aggregator.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
		if (!world.isRemote) {
			Map<Direction, TileEntity> tiles = WorldUtils.getAdjacentTiles(world, pos);

			Map.Entry<Direction, TileEntity> entry = tiles.entrySet().stream()
				.filter((it) -> it.getValue() instanceof MaltyChestTileEntity)
				.findFirst()
				.orElse(null)
			;

			TileEntity tile = entry.getValue();
			if (tile instanceof MaltyChestTileEntity) {
				Direction dir = entry.getKey();
				NetworkHooks.openGui(
					(ServerPlayerEntity) player,
					(MaltyChestTileEntity) tile,
					pos.add(dir.getXOffset(), dir.getYOffset(), dir.getZOffset())
				);
			}
		}
		return ActionResultType.SUCCESS;
	}
}
