package family.hadden.malty.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class MaltyChest extends Block {
	public MaltyChest() {
		super(Block.Properties.create(Material.ROCK));
	}

	// @Override
	// public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	// 	return new TileEntity();
	// }

	// @Override
	// public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {}
}
