package family.hadden.malty.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MaltyChest extends Block {
	public MaltyChest() {
		super(Block.Properties.create(Material.ROCK));
		setRegistryName("malty-chest");
	}

	// @Override
	// public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {}
}
