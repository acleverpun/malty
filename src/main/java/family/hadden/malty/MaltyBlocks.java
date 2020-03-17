package family.hadden.malty;

import family.hadden.malty.block.MaltyChest;
import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(Main.modId)
public class MaltyBlocks {
	public static final MaltyChest maltyChest = new MaltyChest();

	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
			maltyChest
		);
	}
}
