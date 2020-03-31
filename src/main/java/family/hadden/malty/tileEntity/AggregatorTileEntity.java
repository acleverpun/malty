package family.hadden.malty.tileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import family.hadden.malty.container.AggregatorContainer;
import family.hadden.malty.init.Containers;
import family.hadden.malty.init.TileEntityTypes;
import mcjty.lib.api.container.CapabilityContainerProvider;
import mcjty.lib.api.container.DefaultContainerProvider;
import mcjty.lib.container.ContainerFactory;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.tileentity.GenericTileEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

public class AggregatorTileEntity extends GenericTileEntity {
	public static final ContainerFactory containerFactory = new ContainerFactory(0) {
		@Override
		protected void setup() {
			playerSlots(7, 128);
		}
	};

	private LazyOptional<INamedContainerProvider> screenHandler = LazyOptional.of(
		() -> new DefaultContainerProvider<GenericContainer>("Aggregator")
			.containerSupplier((windowId, player) -> new AggregatorContainer(Containers.aggregator.get(), windowId, containerFactory, getPos(), AggregatorTileEntity.this))
	);

	public AggregatorTileEntity() {
		super(TileEntityTypes.aggregator.get());
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityContainerProvider.CONTAINER_PROVIDER_CAPABILITY) return screenHandler.cast();
		return super.getCapability(cap, side);
	}
}
