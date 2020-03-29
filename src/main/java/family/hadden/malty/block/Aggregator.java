package family.hadden.malty.block;

import family.hadden.malty.tileEntity.AggregatorTileEntity;
import mcjty.lib.blocks.BaseBlock;
import mcjty.lib.builder.BlockBuilder;

public class Aggregator extends BaseBlock {
	public Aggregator() {
		super(
			new BlockBuilder()
				.tileEntitySupplier(AggregatorTileEntity::new)
		);
	}
}
