package family.hadden.malty.block;

import javax.annotation.Nullable;

import family.hadden.malty.Main;
import family.hadden.malty.init.TileEntityTypes;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class MaltyChest extends Block {
	public MaltyChest() {
		super(Block.Properties.create(Material.ROCK));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
		return TileEntityTypes.maltyChest.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
		Main.log.debug(world.isRemote);
		if (!world.isRemote) {
			final TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof MaltyChestTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (MaltyChestTileEntity) tileEntity, pos);
			}
		}
		return ActionResultType.SUCCESS;
	}
}
