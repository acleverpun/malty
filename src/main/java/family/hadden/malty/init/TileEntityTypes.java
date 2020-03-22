package family.hadden.malty.init;

import family.hadden.malty.Main;
import family.hadden.malty.tileEntity.AccepterTileEntity;
import family.hadden.malty.tileEntity.AggregatorTileEntity;
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

	public static final RegistryObject<TileEntityType<AccepterTileEntity>> accepter = registry.register(
		"accepter",
		() -> TileEntityType.Builder.create(AccepterTileEntity::new, Blocks.accepter.get()).build(null)
	);

	public static final RegistryObject<TileEntityType<AggregatorTileEntity>> aggregator = registry.register(
		"aggregator",
		() -> TileEntityType.Builder.create(AggregatorTileEntity::new, Blocks.aggregator.get()).build(null)
	);
}
