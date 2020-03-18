package family.hadden.malty.block;

import javax.annotation.Nullable;

import family.hadden.malty.Main;
import family.hadden.malty.init.TileEntityTypes;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;

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
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> openGui(world, pos));
		return ActionResultType.SUCCESS;
	}

	@OnlyIn(Dist.CLIENT)
	private void openGui(final World world, final BlockPos pos) {
		if (world.isRemote) {
			final TileEntity tileEntity = world.getTileEntity(pos);
			Main.log.debug("Wait for it...");
			if (tileEntity instanceof MaltyChestTileEntity) {
				Main.log.debug("Yeppers");
			}
		}
	}
}
