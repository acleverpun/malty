package family.hadden.malty.init;

import family.hadden.malty.Main;
import family.hadden.malty.block.Accepter;
import family.hadden.malty.block.Aggregator;
import family.hadden.malty.block.MaltyChest;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Blocks {
	public static final DeferredRegister<Block> registry = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.modId);

	public static final RegistryObject<Block> maltyChest = registry.register("malty-chest", () -> new MaltyChest());

	public static final RegistryObject<Block> accepter = registry.register("accepter", () -> new Accepter());
	public static final RegistryObject<Block> aggregator = registry.register("aggregator", () -> new Aggregator());
}
