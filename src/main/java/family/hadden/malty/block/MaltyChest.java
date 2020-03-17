package family.hadden.malty.block;

import family.hadden.malty.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Main.modId, bus = Bus.MOD)
@ObjectHolder(Main.modId)
public class MaltyChest {
	public static Block maltyChest;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		maltyChest = new Block(Block.Properties.create(Material.ROCK))
			.setRegistryName("malty-chest");

		event.getRegistry().registerAll(
			maltyChest
		);
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			new BlockItem(maltyChest, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName(maltyChest.getRegistryName())
		);
	}
}
