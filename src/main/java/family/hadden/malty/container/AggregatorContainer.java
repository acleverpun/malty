package family.hadden.malty.container;

import javax.annotation.Nullable;

import family.hadden.malty.Main;
import mcjty.lib.McJtyLib;
import mcjty.lib.api.container.CapabilityContainerProvider;
import mcjty.lib.container.ContainerFactory;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.tileentity.GenericTileEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;

public class AggregatorContainer extends GenericContainer {
	// public static ContainerType<Container> createContainerType(String registryName) {
	// 	Main.log.debug("createContainerType " + registryName);
	// 	ContainerType<Container> containerType = IForgeContainerType.create((windowId, inv, data) -> {
	// 		BlockPos pos = data.readBlockPos();
	// 		TileEntity te = McJtyLib.proxy.getClientWorld().getTileEntity(pos);
	// 		if (te == null) {
	// 			throw new IllegalStateException("Something went wrong getting the GUI");
	// 		}
	// 		return te.getCapability(CapabilityContainerProvider.CONTAINER_PROVIDER_CAPABILITY).map(h -> h.createMenu(windowId, inv, McJtyLib.proxy.getClientPlayer())).orElseThrow(RuntimeException::new);
	// 	});
	// 	containerType.setRegistryName(registryName);
	// 	return containerType;
	// }

	// public static <T extends Container> ContainerType<T> createContainerType() {
	// 	Main.log.debug("createContainerType");
	// 	ContainerType<Container> containerType = IForgeContainerType.create((windowId, inv, data) -> {
	// 		BlockPos pos = data.readBlockPos();
	// 		TileEntity te = McJtyLib.proxy.getClientWorld().getTileEntity(pos);
	// 		if (te == null) {
	// 			throw new IllegalStateException("Something went wrong getting the GUI");
	// 		}
	// 		return te.getCapability(CapabilityContainerProvider.CONTAINER_PROVIDER_CAPABILITY).map(h -> h.createMenu(windowId, inv, McJtyLib.proxy.getClientPlayer())).orElseThrow(RuntimeException::new);
	// 	});
	// 	return (ContainerType<T>) containerType;
	// }

	public AggregatorContainer(@Nullable ContainerType<?> type, int id, ContainerFactory factory, BlockPos pos, @Nullable GenericTileEntity te) {
		super(type, id, factory, pos, te);
		Main.log.debug("aggregator container");
	}
}
