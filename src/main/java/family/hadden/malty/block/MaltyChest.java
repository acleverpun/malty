package family.hadden.malty.block;

import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class MaltyChest extends Block {
	public MaltyChest() {
		super(Block.Properties.create(Material.ROCK));
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
		return TileEntityTypes.maltyChest.get().create();
	}

	// @Override
	// public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {}
}
