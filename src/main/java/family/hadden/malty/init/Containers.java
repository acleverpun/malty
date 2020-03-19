package family.hadden.malty.init;

import family.hadden.malty.Main;
import family.hadden.malty.container.MaltyChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Containers {
	public static final DeferredRegister<ContainerType<?>> registry = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Main.modId);

	public static final RegistryObject<ContainerType<MaltyChestContainer>> maltyChest = registry.register(
		"malty-chest",
		() -> IForgeContainerType.create(MaltyChestContainer::new)
	);
}
