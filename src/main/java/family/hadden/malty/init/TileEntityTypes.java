package family.hadden.malty.init;

import family.hadden.malty.Main;
import family.hadden.malty.tileEntity.MaltyChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class TileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> registry = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Main.modId);

	public static final RegistryObject<TileEntityType<MaltyChestTileEntity>> maltyChest = registry.register(
		"malty-chest",
		() -> TileEntityType.Builder.create(MaltyChestTileEntity::new, Blocks.maltyChest.get()).build(null)
	);
}
