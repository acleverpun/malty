package family.hadden.malty.init;

import family.hadden.malty.Main;
import family.hadden.malty.block.MaltyChest;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.modId)
public class TileEntityTypes {
	public static final MaltyChest maltyChest = new MaltyChest();

	public static void register(IForgeRegistry<TileEntityType<?>> registry) {
	}
}
