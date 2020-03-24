package family.hadden.malty.tileEntity;

import javax.annotation.Nonnull;

import family.hadden.malty.container.AggregatorContainer;
import family.hadden.malty.init.Blocks;
import family.hadden.malty.init.TileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AggregatorTileEntity extends TileEntity implements INamedContainerProvider {
	public AggregatorTileEntity() {
		super(TileEntityTypes.aggregator.get());
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent(Blocks.aggregator.get().getTranslationKey());
	}

	@Nonnull
	@Override
	public Container createMenu(final int windowId, final PlayerInventory inv, final PlayerEntity player) {
		return new AggregatorContainer(windowId, inv, this);
	}
}
