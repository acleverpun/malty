package family.hadden.malty.block;

import javax.annotation.Nullable;

import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class Accepter extends Block {
	public Accepter() {
		super(Block.Properties.create(Material.WOOD));
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
		return TileEntityTypes.accepter.get().create();
	}
}
